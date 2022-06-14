/*a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.*/
select * from familias where num_hijos >= 3 and edad_maxima < 10;
/*
b) Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de
agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
*/
select * from casas where fecha_desde >= '2020-08-01' and fecha_hasta <= '2020-08-31' and pais = 'Reino Unido'; 
/*c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.*/
select * from familias where email like '%hotmail.com';
/*
d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha
dada (2020-06-01) y un número de días específico (20).
*/
select * from casas where fecha_desde >= '2020-06-01' and tiempo_maximo >= 20;
/*
e) Listar los datos de todos los clientes que en algún momento realizaron una estancia
y la descripción de la casa donde la realizaron.
*/

/*
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre,
país y ciudad del cliente y además la información de la casa que reservó. La que
reemplazaría a la anterior
g) Debido a la devaluación de la libra esterlina con respecto al euro se desea
incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar
los precios actualizados.
h) Obtener el número de casas que existen para cada uno de los países diferentes.
i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas
(comentarios) que están ‘limpias’.
j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.*/