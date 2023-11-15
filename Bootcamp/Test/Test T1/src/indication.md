Nos piden que programemos los NPCs de un juego de rol. Existen tres categorías de NPCs: Campesino, Ladrón y Mercader. Todos ellos venden ítems. El campesino tiene hasta 5 ítems para vender y al precio original le agrega un impuesto del 2%. El ladrón, hasta 3 y no cobra impuestos. El mercader, hasta 7 y cobra un 4% de impuestos. Cada NPC está ubicado en una ciudad. Los ítems tienen un nombre, un tipo, un precio y porcentaje de desgaste. Cuando un ladrón agrega un ítem a su inventario este se deteriora un 25%. Cuando lo hace un campesino, un 15%. En cambio, un mercader conoce muy bien cómo guardar sus ítems para que no se estropeen. 

La aplicación permite:
1- Consultar los los ítems de un vendedor.
2- Consultar los vendedores que hay en una ciudad.
3- Mostrar el ítems más barato de todos los vendedores de una ciudad
4- Mostrar todos los ítems de un determinado tipo ordenados por precio (asc).
5- Simular la compra de un ítem a un NPC.
6- Simular la venta de un ítem a un NPC.*
7- Serializar en un fichero JSON la información de cada NPC (categoría, ubicación, items: nombre, tipo, precio, desgaste..)


Si se intenta agregar más ítems de los que un NPC puede vender una excepción mostrará el MENSAJE:"[Inventario lleno!- El vendedor no puede comprar el ítem].".

Crea una aplicación en java que permita:
Crear 3 tipos de npc: Campesino, ladrón y mercader. Todos los npcs venden ítems.
El campesino tiene hasta 5 ítems para vender y le agrega un 2% al precio original del item en concepto de impuestos. Cada vez que un item es agregado en su inventario, este item sufre un 15% de desgaste
El ladrón tiene hasta 3 items para vender y no agrega nada al precio original ya que no cobra impuestos. Cada vez que un item es agregado en su inventario, este item sufre un 25% de desgaste
El mercader tiene hasta 7 items para vender y le agrega un 4% al precio original del item en concepto de impuestos. Cada vez que un item es agregado en su inventario, este item no sufre desgaste
Cada npc está ubicaco en una ciudad
los ítmes tienen las siguientes variables: nombre, tipo, precio y porcentaje de desgaste.
Consultar los los ítems de un vendedor.
Consultar los vendedores que hay en una ciudad.
Mostrar el ítems más barato de todos los vendedores de una ciudad
Mostrar todos los ítems de un determinado tipo ordenados por precio (asc).
Simular la compra de un ítem a un NPC.
Simular la venta de un ítem a un NPC.*
Serializar en un fichero JSON la información de cada NPC (categoría, ubicación, items: nombre, tipo, precio, desgaste..)