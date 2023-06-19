package com.gmail.vladimirprocean.moviegalleryapp.service;

import com.gmail.vladimirprocean.moviegalleryapp.model.Library;
import com.gmail.vladimirprocean.moviegalleryapp.repository.LibraryRepository;

public class LibraryService {
    private LibraryRepository libraryRepository;
    private Library library;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }
    public void addToWatched(int id){
        this.library.getWatchedMovies().add(id);
    }
}
