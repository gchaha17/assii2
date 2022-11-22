package com.example.assignment2.resource;


import com.example.assignment2.Album;
import com.example.assignment2.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {
    @Autowired
    private AlbumService albumService;
    @GetMapping("/album")
    public Album getAlbum()
    {
        return albumService.getAlbum();

    }
    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album)
    {
        return albumService.saveAlbum(album);

    }
    @GetMapping("/allalbum")
    public List<Album> getAllAlbum(){
        return albumService.getAllAlbum();

    }
    @GetMapping("/album/{albumId}") //this is how we add a path variable
    public Album getAlbumById(@PathVariable("albumId") int albumId)
    {
        return albumService.getAlbumById(albumId);
    }

    @PutMapping("/album/{albumId}")
    public Album updateAlbum(@PathVariable("albumId") int albumId,@RequestBody Album album)
    {
        return albumService.updateAlbum(albumId,album);
    }
    @DeleteMapping("/album")
    public Album deleteUser(@RequestParam(name = "albumId") int albumId)
    {
        return albumService.deleteAlbum(albumId);
    }
}