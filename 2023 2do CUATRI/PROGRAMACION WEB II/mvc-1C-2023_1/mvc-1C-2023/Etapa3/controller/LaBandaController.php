<?php

class LaBandaController {

    private $renderer;

    public function __construct($renderer) {
        $this->renderer = $renderer;
    }

    public function list() {
        $this->renderer->render('labanda');
    }
}