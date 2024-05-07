<?php

class SongsController {
    private $songsModel;

    public function __construct($songsModel) {
        $this->songsModel = $songsModel;
    }

    public function list() {
        $canciones = $this->songsModel->getSongs();
        include_once('view/songs_view.php');
    }
}