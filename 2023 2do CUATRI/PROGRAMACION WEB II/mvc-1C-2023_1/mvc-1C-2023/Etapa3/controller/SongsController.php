<?php

class SongsController {
    private $songsModel;
    private $renderer;

    public function __construct($songsModel, $renderer) {
        $this->songsModel = $songsModel;
        $this->renderer = $renderer;
    }

    public function list() {
        $data["canciones"] = $this->songsModel->getSongs();
        $this->renderer->render("songs", $data);
    }

    public function listen() {
        if  (!isset( $_GET["idCancion"] )){
            header("location:/");
            exit();
        }

        $id = $_GET['idCancion'];

        echo "listening... $id";
    }

}