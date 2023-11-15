public class ErrorMessage {
    
    public static class ItemNotFoundException extends Exception {
        public ItemNotFoundException(String message) {
            super("[Item no encontrado! El vendedor no puede encontrar el item].");
        }
    }

    public class InventoryFullException extends Exception {
        public InventoryFullException(String message) {
            super("[Inventario lleno!- El vendedor no puede comprar el ítem].");
        }
    }
}
