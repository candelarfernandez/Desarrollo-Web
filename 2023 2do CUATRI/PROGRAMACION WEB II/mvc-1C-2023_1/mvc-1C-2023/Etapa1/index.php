<?php
include_once('Configuration.php');
$configuration = new Configuration();
$database = $configuration->getDatabase();

$page = $_GET["page"];
include_once('view/header.php');
switch ($page){
    case 'tours':
        $tourController = $configuration->getTourController();
        $tourController->list();
        break;
    case "songs":
        $songsController = $configuration->getSongsController();
        $songsController->list();
        break;
    default:
        $laBandaController = $configuration->getLaBandaController();
        $laBandaController->list();
        break;
}
include_once('view/footer.php');


