use TallerWeb2;

CREATE TABLE productos(
id INT auto_increment primary key,
nombre varchar(255),
descripcion varchar(255),
precio double,
imagen varchar(255)
);

INSERT INTO `productos` (`id`,`nombre`,`descripcion`,`precio`,`imagen`) VALUES (1,'Cartuchera Doble Cierre Multiuso','Dimenciones: 24 cm x 13 cm x 7 cm. Escolar Viajes Neceser',1200,'https://http2.mlstatic.com/D_NQ_NP_2X_677701-MLA48346676179_112021-F.webp');
INSERT INTO `productos` (`id`,`nombre`,`descripcion`,`precio`,`imagen`) VALUES (2,'Regla Plastica Pizzini','1712 Cristal 20Cm.Color cristal. Escala inalterable.',1500,'https://acdn.mitiendanube.com/stores/601/518/products/regla20cm1-3a88d0c8de3414486f16819948268705-1024-1024.webp');
INSERT INTO `productos` (`id`,`nombre`,`descripcion`,`precio`,`imagen`) VALUES (3,'EXITO CUADERNO ABC','CUADRICULADO GRANDE CUADERNOS ESCOLARES',3.651,'https://www.heavenimagenes.com/heavencommerce/11de0e5d-73b3-4c32-910b-8483d00a7205/images/v2/EXITO/7473_medium.jpg');
INSERT INTO `productos` (`id`,`nombre`,`descripcion`,`precio`,`imagen`) VALUES (4,'Lápiz Grafito Negro Noris','Staedtler Caja X12 Unidades Hb Nº2 Color Gris Oscuro',1300,'https://http2.mlstatic.com/D_NQ_NP_2X_721154-MLU72637655205_112023-F.webp');
INSERT INTO `productos` (`id`,`nombre`,`descripcion`,`precio`,`imagen`) VALUES (5,'Boligrafo Lapicera Cristal','Color Azul X 10u Trazo Punta 1 Mm',500,'https://http2.mlstatic.com/D_NQ_NP_2X_837505-MLA51933201311_102022-F.webp');
INSERT INTO `productos` (`id`,`nombre`,`descripcion`,`precio`,`imagen`) VALUES (6,'Goma De Borrar Maped','Goma de borrar maped',1250,'https://http2.mlstatic.com/D_NQ_NP_2X_687453-MLA54844036780_042023-F.webp');
select * from productos;



