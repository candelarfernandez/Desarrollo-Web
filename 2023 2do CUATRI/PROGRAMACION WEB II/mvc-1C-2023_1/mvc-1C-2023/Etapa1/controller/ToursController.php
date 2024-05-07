<?php

class ToursController {
    private $toursModel;

    public function __construct($toursModel) {
        $this->toursModel = $toursModel;
    }

    public function list() {
        $presentaciones = $this->toursModel->getTours();
        include_once('view/tours_view.php');
    }
}