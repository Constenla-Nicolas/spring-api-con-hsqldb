# Spring api con HSQLDB

Api hecha en spring con conexion a una HSQLDB bdd en memoria
La url base para todos los EndPoints es localhost:8080/api


# EndPoints

Reemplazar {productId} con un id.

- /get   Devuelve la lista completa de elementos en la bdd.

- /getProduct/{productId} Consulta un elemento de la lista por nombre o id.

- /delete/{productId}   Elimina un elemento de la lista usando su id.

- /sorbyprice   Devuelve la lista completa de elementos ordenados descendentemente por precio.

- /put/{productId} Actualiza un elemento de la lista usando su id. 

- /post/   Crea un elemento en la lista.


<h3> Parametros para usar con /post y /put | No son necesarios todos los parametros. (De no usar un parametro, quedara en null/0 en el caso de /post y con el valor anterior en caso de /put)</h3>

- "name" : Nombre del elemento.

- "description" : Descripcion del elemento.

- "price" : Precio del elemento.

- "amount" : Cantidad de elementos.

# Modelo

[ProductModel](https://github.com/Constenla-Nicolas/spring-api-con-hsqldb/blob/main/src/main/java/com/Productos/model/ProductModel.java) Modelo del producto.
