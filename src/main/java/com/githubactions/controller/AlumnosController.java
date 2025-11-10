package com.githubactions.controller;

import com.githubactions.domain.Alumnos;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnosController {

    private List<Alumnos> alumnos = new ArrayList<Alumnos>(Arrays.asList( new Alumnos(1234, "Fernando", "fer@gmail.com", 23, "Ingles"),
            new Alumnos(12345, "Jose", "jose@gmail.com", 42, "Ingles"),
            new Alumnos(12346, "Luis", "luis@gmail.com", 18, "Ingles"),
            new Alumnos(12347, "Pedro", "pedro@gmail.com", 50, "Ingles")
    ));


    @GetMapping()
    public List<Alumnos> getAlumnos(){
        return alumnos;
    }

    @GetMapping("/{nombre}")
    public Alumnos getAlumno(@PathVariable String nombre){
        for(Alumnos c : alumnos){
            if(c.getNombre().equalsIgnoreCase(nombre)){
                return c;
            }
        }
        return null;
    }

    @PostMapping()
    public Alumnos postAlumno(@RequestBody Alumnos alumno){
        alumnos.add(alumno);
        return  alumno;
    }

    @PatchMapping()
    public Alumnos pathAlumno(@RequestBody Alumnos alumno){
        for(Alumnos c : alumnos){
            if(c.getId() == alumno.getId()){
                if(alumno.getNombre() != null){
                    c.setNombre(alumno.getNombre());
                }
                if(alumno.getCorreo() != null){
                    c.setCorreo(alumno.getCorreo());
                }
                if(alumno.getEdad() != 0){
                    c.setEdad(alumno.getEdad());
                }
                if(alumno.getCurso() != null){
                    c.setCurso(alumno.getCurso());
                }
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public Alumnos deleteAlumno(@PathVariable int id){
        for(Alumnos c : alumnos){
            if(c.getId() == id){
                alumnos.remove(c);
                return c;
            }
        }
        return null;
    }
}
