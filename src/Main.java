import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    private static List<Empleado> empleados = new ArrayList<>();
    private static List<Departamento> departamentos = new ArrayList<>();  // Lista de departamentos

    public static void main(String[] args) {
        // Crear ventana principal
        JFrame frame = new JFrame("Sistema de Gestión de Empleados y Departamentos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Crear barra de menú
        JMenuBar menuBar = new JMenuBar();

        // Menú de empleados
        JMenu menuEmpleados = new JMenu("Empleados");
        JMenuItem addEmpleadoItem = new JMenuItem("Agregar Empleado");
        JMenuItem viewEmpleadosItem = new JMenuItem("Ver Empleados");
        JMenuItem updateEmpleadoItem = new JMenuItem("Actualizar Empleado");
        JMenuItem deleteEmpleadoItem = new JMenuItem("Eliminar Empleado");

        menuEmpleados.add(addEmpleadoItem);
        menuEmpleados.add(viewEmpleadosItem);
        menuEmpleados.add(updateEmpleadoItem);
        menuEmpleados.add(deleteEmpleadoItem);
        menuBar.add(menuEmpleados);

        // Menú de departamentos
        JMenu menuDepartamentos = new JMenu("Departamentos");
        JMenuItem addDepartamentoItem = new JMenuItem("Crear Departamento");
        JMenuItem viewDepartamentoItem = new JMenuItem("Ver Departamentos");
        JMenuItem updateDepartamentoItem = new JMenuItem("Modificar Departamento");
        JMenuItem deleteDepartamentoItem = new JMenuItem("Eliminar Departamento");
        JMenuItem assignEmpleadoItem = new JMenuItem("Asignar Empleado a Departamento");

        menuDepartamentos.add(addDepartamentoItem);
        menuDepartamentos.add(viewDepartamentoItem);
        menuDepartamentos.add(updateDepartamentoItem);
        menuDepartamentos.add(deleteDepartamentoItem);
        menuDepartamentos.add(assignEmpleadoItem);
        menuBar.add(menuDepartamentos);

        frame.setJMenuBar(menuBar);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout());

        // Área de texto para mostrar empleados y departamentos
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Añadir el panel al JFrame
        frame.add(panel);

        // Acción para agregar empleado
        addEmpleadoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField();
                JTextField nombreField = new JTextField();
                JTextField edadField = new JTextField();

                String[] opcionesSexo = {"Hombre", "Mujer", "No binario"};
                JComboBox<String> sexoBox = new JComboBox<>(opcionesSexo);

                String[] opcionesTipo = {"Permanente", "Temporal"};
                JComboBox<String> tipoBox = new JComboBox<>(opcionesTipo);

                JTextField salarioBaseField = new JTextField(); // Solo para empleados permanentes
                JTextField tasaPorHoraField = new JTextField(); // Solo para empleados temporales

                Object[] message = {
                        "ID:", idField,
                        "Nombre:", nombreField,
                        "Edad:", edadField,
                        "Sexo:", sexoBox,
                        "Tipo (permanente/temporal):", tipoBox,
                        "Salario Base (solo para permanentes):", salarioBaseField,
                        "Tasa por Hora (solo para temporales):", tasaPorHoraField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Agregar Empleado", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        String nombre = nombreField.getText();
                        int edad = Integer.parseInt(edadField.getText());
                        String sexo = (String) sexoBox.getSelectedItem();
                        String tipo = (String) tipoBox.getSelectedItem();

                        if (tipo.equalsIgnoreCase("Permanente")) {
                            float salarioBase = Float.parseFloat(salarioBaseField.getText());
                            empleados.add(EmpleadoFactory.crearEmpleado("permanente", id, nombre, edad, sexo, new Date(), "Seguro Médico", salarioBase, null, 0));
                            JOptionPane.showMessageDialog(frame, "Empelado creado.");
                        } else if (tipo.equalsIgnoreCase("Temporal")) {
                            float tasaPorHora = Float.parseFloat(tasaPorHoraField.getText());
                            empleados.add(EmpleadoFactory.crearEmpleado("temporal", id, nombre, edad, sexo, new Date(), null, 0, new Date(), tasaPorHora));
                            JOptionPane.showMessageDialog(frame, "Empelado creado.");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error en los datos ingresados. Por favor, verifica los campos.");
                    }
                }
            }
        });

        // Acción para ver empleados
        viewEmpleadosItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");  // Limpiar área de texto
                if (empleados.isEmpty()) {
                    displayArea.setText("No hay empleados para mostrar.\n");
                } else {
                    empleados.forEach(empleado -> displayArea.append(empleado.getDetalles() + "\n"));
                }
            }
        });

        // Acción para crear departamento
        addDepartamentoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField();
                JTextField nombreField = new JTextField();
                JTextField jefeField = new JTextField();
                JTextField descripcionField = new JTextField();

                Object[] message = {
                        "ID:", idField,
                        "Nombre del Departamento:", nombreField,
                        "Jefe de Departamento:", jefeField,
                        "Descripción:", descripcionField
                };

                int option = JOptionPane.showConfirmDialog(null, message, "Crear Departamento", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    int id = Integer.parseInt(idField.getText());
                    String nombre = nombreField.getText();
                    String jefe = jefeField.getText();
                    String descripcion = descripcionField.getText();

                    departamentos.add(new Departamento(id, nombre, jefe, descripcion));
                    JOptionPane.showMessageDialog(frame, "Departamento creado.");
                }
            }
        });

        // Acción para ver departamentos
        viewDepartamentoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText("");  // Limpiar área de texto
                if (departamentos.isEmpty()) {
                    displayArea.setText("No hay departamentos para mostrar.\n");
                } else {
                    departamentos.forEach(departamento -> displayArea.append(departamento.getDetalles() + "\n"));
                    empleados.forEach(empleado -> displayArea.append(empleado.getDetalles() + "\n"));
                }
            }
        });

        // Acción para modificar departamento
        updateDepartamentoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Ingrese el ID del departamento a modificar:");
                int id = Integer.parseInt(idStr);
                Departamento departamento = buscarDepartamentoPorID(id);

                if (departamento != null) {
                    JTextField nombreField = new JTextField(departamento.getNombre());
                    JTextField jefeField = new JTextField(departamento.getJefeDepartamento());
                    JTextField descripcionField = new JTextField(departamento.getDescripcion());

                    Object[] message = {
                            "Nombre del Departamento:", nombreField,
                            "Jefe de Departamento:", jefeField,
                            "Descripción:", descripcionField
                    };

                    int option = JOptionPane.showConfirmDialog(null, message, "Modificar Departamento", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        departamento.setNombre(nombreField.getText());
                        departamento.setJefeDepartamento(jefeField.getText());
                        departamento.setDescripcion(descripcionField.getText());
                        JOptionPane.showMessageDialog(frame, "Departamento actualizado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Departamento no encontrado.");
                }
            }
        });

        // Acción para eliminar departamento
        deleteDepartamentoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog("Ingrese el ID del departamento a eliminar:");
                int id = Integer.parseInt(idStr);
                Departamento departamento = buscarDepartamentoPorID(id);

                if (departamento != null) {
                    departamentos.remove(departamento);
                    JOptionPane.showMessageDialog(frame, "Departamento eliminado.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Departamento no encontrado.");
                }
            }
        });

        // Acción para asignar empleado a departamento
        assignEmpleadoItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idDepartamentoStr = JOptionPane.showInputDialog("Ingrese el ID del Departamento:");
                String idEmpleadoStr = JOptionPane.showInputDialog("Ingrese el ID del Empleado:");

                int idDepartamento = Integer.parseInt(idDepartamentoStr);
                int idEmpleado = Integer.parseInt(idEmpleadoStr);

                Departamento departamento = buscarDepartamentoPorID(idDepartamento);
                Empleado empleado = buscarEmpleadoPorID(idEmpleado);

                if (departamento != null && empleado != null) {
                    departamento.asignarEmpleado(empleado);
                    JOptionPane.showMessageDialog(frame, "Empleado asignado al departamento.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Departamento o empleado no encontrado.");
                }
            }
        });

        // Hacer visible el JFrame
        frame.setVisible(true);
    }

    // Método para buscar empleado por ID
    private static Empleado buscarEmpleadoPorID(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }

    // Método para buscar departamento por ID
    private static Departamento buscarDepartamentoPorID(int id) {
        for (Departamento departamento : departamentos) {
            if (departamento.getId() == id) {
                return departamento;
            }
        }
        return null;
    }
}
