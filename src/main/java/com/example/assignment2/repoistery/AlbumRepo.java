package com.example.assignment2.repoistery;

import com.example.assignment2.Album;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlbumRepo {

    List<Album> userList=new ArrayList();
    public Album getAlbum() {
        Album album=new Album(1,"surrey,BC","12","dcggd/dhdh");
        return album;
    }

    public Album saveAlbum(Album album) {
        album.setAlbumId(userList.size()+1); // by getting userlist size we can have unique userId's
        userList.add(album);
        return album;
    }

    public List<Album> getAllAlbum() {
        return userList;
    }

    public Album getAlbumById( int albumId) {
        for(Album album:userList)
        {
            if (album.getAlbumId()==albumId)
            {
                return album;
            }
        }
        return null;
    }

    public Album updateAlbum(int albumId, Album album) {
        for(Album u:userList)
        {
            if(u.getAlbumId()==albumId)
            {
                u.setName(album.getName());
                u.setDescription(album.getDescription());
                u.setCoverPicUrl(album.getCoverPicUrl());

                return u;
            }
        }
        return null;

    }

    public Album deleteAlbum(int albumId) {
        Album deletedAlbum=null;
        for(Album u:userList)
        {
            if(u.getAlbumId()==albumId)
            { deletedAlbum=u;
                userList.remove(u);
                return deletedAlbum;


            }
        }
        return deletedAlbum;

    }
}