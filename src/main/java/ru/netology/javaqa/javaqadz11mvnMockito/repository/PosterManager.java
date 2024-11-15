package ru.netology.javaqa.javaqadz11mvnMockito.repository;

public class PosterManager {
    private String[] posters = new String[0];
    private int limitQuality;

    public PosterManager() {
        this.limitQuality = 5;
    }

    public PosterManager(int limitQuality) {
        this.limitQuality = limitQuality;
    }

    public void addPoster(String poster) {
        String[] tmp = new String[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = poster;
        posters = tmp;
    }

    public String[] findAll() {
        return posters;
    }

    public String[] findLast() {
        int resultLength;
        if (posters.length < limitQuality) {
            resultLength = posters.length;
        } else {
            resultLength = limitQuality;
        }
        String[] rez = new String[resultLength];
        for (int i = 0; i < rez.length; i++) {
            rez[i] = posters[posters.length - 1 - i];
        }
        return rez;
    }
}
