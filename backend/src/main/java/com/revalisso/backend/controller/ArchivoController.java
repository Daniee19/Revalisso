package com.revalisso.backend.controller;

import com.revalisso.backend.dto.ArchivoDTO;
import com.revalisso.backend.service.IArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/files")
public class ArchivoController {

    @Autowired
    IArchivoService archivoService;

    // Ruta donde se guardarán las imágenes (carpeta al lado del proyecto)
    private final Path root = Paths.get("uploads");

    public ArchivoController() throws IOException {
        Files.createDirectories(root); // Crea la carpeta "uploads" si no existe
    }

    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        // Generamos un nombre único
        String filename = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        // Guardamos el archivo en la carpeta uploads
        Files.copy(file.getInputStream(), root.resolve(filename), StandardCopyOption.REPLACE_EXISTING);
        // Devolvemos la ruta que luego puedes guardar en la BD
        Map<String, String> response = new HashMap<>();
        response.put("urlFotoAlojada", "/uploads/" + filename);
        return response;
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> agregar(@RequestBody ArchivoDTO archivo){
        System.out.println("En el controller, lo traido del frontend es: "+archivo);
        return ResponseEntity.ok(archivoService.agregarArchivo(archivo));
    }
}
