<?php
include_once('helpers/MySqlDatabase.php');

include_once ("model/ToursModel.php");
include_once('model/SongsModel.php');

include_once('controller/ToursController.php');
include_once('controller/SongsController.php');
include_once('controller/LaBandaController.php');


class Configuration {
    private $configFile = 'config/config.ini';

    public function __construct() {
    }

    public function getDatabase() {
        $config = $this->getArrayConfig();
        return new MySqlDatabase(
            $config['servername'],
            $config['username'],
            $config['password'],
            $config['database']);

    }

    public function getTourController() {
        $database = $this->getDatabase();
        $toursModel = new ToursModel($database);
        return new ToursController($toursModel);
    }


    public function getSongsController() {
        $database = $this->getDatabase();
        $songsModel = new SongsModel($database);
        return new SongsController($songsModel);
    }

    private function getArrayConfig() {
        return parse_ini_file($this->configFile);
    }

    public function getLaBandaController() {
        return new LaBandaController();
    }
}