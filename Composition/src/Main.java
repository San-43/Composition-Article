/***
 * Sandro Martínez Pérez
 * Grupo: 3°1
 * Cuenta: 475218
 */
import javax.swing.*;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int opt;
        ArrayList<Perishable> list = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        do {
            do {
                opt = 0;
                try {
                    opt = Integer.parseInt(JOptionPane.showInputDialog("""
                    ---MENU ARTICULOS---
                    1) Agregar un artículo
                    2) Consultar artículos dados de alta
                    3) Consultar detalle de un artículo
                    4) Salir
                    Elija una opción ->"""));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "La opción debe ser numérica", "", JOptionPane.WARNING_MESSAGE);
                }
            }while (opt < 1);
            switch (opt) {
                case 1 -> {
                    int id;
                    do {
                        id = -1;
                        try {
                            id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la id"));
                            if (ids.contains(id)) {
                                JOptionPane.showMessageDialog(null, "La id ya se encuentra en el sistema", "", JOptionPane.WARNING_MESSAGE);
                                id = -1;
                            }else {
                                ids.add(id);
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "La id debe ser numérica", "", JOptionPane.ERROR_MESSAGE);
                        }
                    }while (id < 0);

                    String description = JOptionPane.showInputDialog("Ingrese la descripción del artículo");
                    String brand = JOptionPane.showInputDialog("Ingrese la marca del artículo");
                    String content = JOptionPane.showInputDialog("Ingrese el contenido del artículo");
                    String category = JOptionPane.showInputDialog("Ingrese la categoría del artículo");

                    float price;
                    do {
                        price = -1.0f;
                        try {
                            price = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el precio"));
                            if (price == 0.0f) {
                                JOptionPane.showMessageDialog(null, "El precio no puede ser de $0", "", JOptionPane.WARNING_MESSAGE);
                                price = -1.0f;
                            }
                        }catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "El precio del artículo debe ser numérico", "", JOptionPane.ERROR_MESSAGE);
                        }
                    }while (price < 0.0f);

                    String status = JOptionPane.showInputDialog("Ingrese el estado del artículo");

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                    LocalDate productionDate;
                    do {
                        try {
                            productionDate = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de producción con el formato dd/MM/yyyy"), formatter);
                            if (productionDate.getYear() < 1970 || productionDate.getYear() > LocalDate.now().getYear()) {
                                JOptionPane.showMessageDialog(null, "La fecha debe estar en un rango de año entre 1970 y el actual", "", JOptionPane.WARNING_MESSAGE);
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "La fecha debe tener formato dd/MM/yyyy y debe ser correcta", "", JOptionPane.WARNING_MESSAGE);
                        }
                    } while (true);

                    LocalDate expiryDate;
                    do {
                        try {
                            expiryDate = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de caducidad con el formato dd/MM/yyyy"), formatter);
                            if (expiryDate.isBefore(productionDate) || expiryDate.getYear() > (productionDate.getYear()+100)) {
                                JOptionPane.showMessageDialog(null, "La fecha de expiración debe ser posterior a la de producción y no exceder en 100 años a esta", "", JOptionPane.WARNING_MESSAGE);
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "La fecha debe tener formato dd/MM/yyyy y debe ser correcta", "", JOptionPane.WARNING_MESSAGE);
                        }
                    } while (true);

                    list.add(new Perishable(id, description, brand, content, category, price, status, productionDate, expiryDate));
                }
                case 2 -> {
                    if (!list.isEmpty()) {
                        StringBuilder tmp = new StringBuilder("""
                                        Id Articulo       Descripción               Marca                 Fecha de Caducidad
                                                            
                                     ------------------------------------------------------------------------------------------
                                """);
                        for (Perishable i :
                                list) {
                            tmp.append("\n        ").append(i.getId()).append("                   ").append(i.getDescription())
                                    .append("                           ").append(i.getBrand()).append("                      ")
                                    .append(i.getExpiryDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        }

                        JOptionPane.showMessageDialog(null, tmp, "Artículos", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha ingresado ningún artículo", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
                case 3 -> {
                    if (!ids.isEmpty()) {
                        int id;
                        do {
                            id = -1;
                            try {
                                id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la id del artículo a buscar"));
                                if (ids.contains(id)) {
                                    int finalId = id;
                                    list.forEach(perishable -> {

                                        if (perishable.getId() == finalId) {
                                            JOptionPane.showMessageDialog(null, perishable.getData(), "", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    });
                                }else {
                                    JOptionPane.showMessageDialog(null, "La id no se encuentra registrada", "", JOptionPane.WARNING_MESSAGE);
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "La id debe ser numérica", "", JOptionPane.ERROR_MESSAGE);
                            }
                        }while (id < 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se ha ingresado ningún artículo", "", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        } while (opt != 4);
    }
}