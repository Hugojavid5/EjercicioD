package org.hugo.ejerciciod;

import Model.Persona;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * La clase PersonaController es responsable de manejar las interacciones
 * de la interfaz gráfica de usuario relacionadas con las personas.
 * Proporciona métodos para agregar, eliminar, modificar y cargar datos
 * de personas en una tabla.
 */
public class PersonaController {

    @FXML
    private TableColumn<Persona, String> c_apellidos;

    @FXML
    private TableColumn<Persona, Integer> c_edad;

    @FXML
    private TableColumn<Persona, String> c_Nombre;

    @FXML
    private TableView<Persona> tablaPersonas;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtEdad;

    @FXML
    private TextField txtNombre;

    /**
     * Muestra un mensaje de error en una ventana de alerta.
     *
     * @param error El mensaje de error que se mostrará.
     */
    @FXML
    void mostrarError(String error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(error);
        alert.showAndWait();
    }

    /**
     * Muestra un mensaje de información en una ventana de alerta.
     *
     * @param info El mensaje de información que se mostrará.
     */
    @FXML
    void mostrarInfo(String info) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Info");
        alert.setContentText(info);
        alert.showAndWait();
    }

    /**
     * Limpia los campos de texto y la selección de la tabla.
     */
    @FXML
    void limpiarDatos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtEdad.setText("");
        tablaPersonas.getSelectionModel().clearSelection();
    }

    /**
     * Carga los datos de la persona seleccionada en la tabla
     * en los campos de texto correspondientes.
     *
     * @param event El evento de mouse que activa el método.
     */
    @FXML
    void cargarDatos(MouseEvent event) {
        Persona p = tablaPersonas.getSelectionModel().getSelectedItem();
        if (p != null) {
            txtNombre.setText(p.getNombre());
            txtApellidos.setText(p.getApellidos());
            txtEdad.setText(p.getEdad() + "");
        }
    }

    /**
     * Agrega una nueva persona a la tabla después de validar los datos ingresados.
     *
     * @param event El evento de acción que activa el método.
     */
    @FXML
    void ag_persona(ActionEvent event) {
        String error = "";
        if (txtNombre.getText().isEmpty()) {
            error += "Introduce un Nombre\n";
        }
        if (txtApellidos.getText().isEmpty()) {
            error += "Introduce un Apellido\n";
        }
        if (txtEdad.getText().isEmpty()) {
            error += "Introduce una Edad\n";
        } else {
            try {
                int edad = Integer.parseInt(txtEdad.getText());
                if (edad <= 0) {
                    throw new Exception();
                }
            } catch (NumberFormatException e) {
                error += "Introduce un entero como Edad\n";
            } catch (Exception e) {
                error += "Introduce un número superior a 0\n";
            }
        }
        if (error.isEmpty()) {
            Boolean existe = false;
            Persona p = new Persona(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()));
            for (Persona persona : tablaPersonas.getItems()) {
                if (persona.equals(p)) {
                    mostrarError("Esa persona ya existe en la tabla");
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                tablaPersonas.getItems().add(p);
                limpiarDatos();
                mostrarInfo("Persona añadida correctamente");
            }
        } else {
            mostrarError(error);
        }
    }

    /**
     * Elimina la persona seleccionada de la tabla.
     *
     * @param event El evento de acción que activa el método.
     */
    @FXML
    void eliminar(ActionEvent event) {
        Persona p = tablaPersonas.getSelectionModel().getSelectedItem();
        if (p == null) {
            mostrarError("Selecciona una persona de la tabla");
        } else {
            tablaPersonas.getItems().remove(p);
            limpiarDatos();
            mostrarInfo("Persona eliminada correctamente");
        }
    }

    /**
     * Modifica los datos de la persona seleccionada en la tabla
     * después de validar los datos ingresados.
     *
     * @param event El evento de acción que activa el método.
     */
    @FXML
    void modificar(ActionEvent event) {
        Persona personaSeleccionada = tablaPersonas.getSelectionModel().getSelectedItem();
        if (personaSeleccionada == null) {
            mostrarError("Selecciona una persona de la tabla");
        } else {
            // Comprobar Datos
            String error = "";
            if (txtNombre.getText().isEmpty()) {
                error += "Introduce un Nombre\n";
            }
            if (txtApellidos.getText().isEmpty()) {
                error += "Introduce un Apellido\n";
            }
            if (txtEdad.getText().isEmpty()) {
                error += "Introduce una Edad\n";
            } else {
                try {
                    int edad = Integer.parseInt(txtEdad.getText());
                    if (edad <= 0) {
                        throw new Exception();
                    }
                } catch (NumberFormatException e) {
                    error += "Introduce un entero como Edad\n";
                } catch (Exception e) {
                    error += "Introduce un número superior a 0\n";
                }
            }

            if (error.isEmpty()) {
                // Comprobar si existe
                Boolean existe = false;
                Persona p = new Persona(txtNombre.getText(), txtApellidos.getText(), Integer.parseInt(txtEdad.getText()));
                for (Persona persona : tablaPersonas.getItems()) {
                    if (persona.equals(p)) {
                        mostrarError("Esa persona ya existe en la tabla");
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    // Actualizar los datos de la persona seleccionada
                    personaSeleccionada.setNombre(txtNombre.getText());
                    personaSeleccionada.setApellidos(txtApellidos.getText());
                    personaSeleccionada.setEdad(Integer.parseInt(txtEdad.getText()));
                    tablaPersonas.refresh();
                    limpiarDatos();
                    mostrarInfo("Persona modificada correctamente");
                }
            } else {
                mostrarError(error);
            }
        }
    }
}
