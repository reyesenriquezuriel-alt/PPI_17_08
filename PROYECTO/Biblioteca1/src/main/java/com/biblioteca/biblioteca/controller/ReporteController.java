package com.biblioteca.biblioteca.controller;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.biblioteca.entity.Libro;
import com.biblioteca.biblioteca.entity.Prestamo;
import com.biblioteca.biblioteca.entity.Reserva;
import com.biblioteca.biblioteca.entity.Usuario;
import com.biblioteca.biblioteca.repository.LibroRepository;
import com.biblioteca.biblioteca.repository.PrestamoRepository;
import com.biblioteca.biblioteca.repository.ReservaRepository;
import com.biblioteca.biblioteca.repository.UsuarioRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@RestController
public class ReporteController {

    private final LibroRepository libroRepository;
    private final UsuarioRepository usuarioRepository;
    private final PrestamoRepository prestamoRepository;
    private final ReservaRepository reservaRepository;

    public ReporteController(
            LibroRepository libroRepository,
            UsuarioRepository usuarioRepository,
            PrestamoRepository prestamoRepository,
            ReservaRepository reservaRepository) {

        this.libroRepository = libroRepository;
        this.usuarioRepository = usuarioRepository;
        this.prestamoRepository = prestamoRepository;
        this.reservaRepository = reservaRepository;
    }

    @GetMapping("/api/reportes/libros")
    public ResponseEntity<byte[]> reporteLibros() throws Exception {

        List<Libro> libros =
                libroRepository.findAll();

        return generarPdfLibros(libros);
    }

    @GetMapping("/api/reportes/usuarios")
    public ResponseEntity<byte[]> reporteUsuarios() throws Exception {

        List<Usuario> usuarios =
                usuarioRepository.findAll();

        return generarPdfUsuarios(usuarios);
    }

    @GetMapping("/api/reportes/prestamos")
    public ResponseEntity<byte[]> reportePrestamos() throws Exception {

        List<Prestamo> prestamos =
                prestamoRepository.findAll();

        return generarPdfPrestamos(prestamos);
    }

    @GetMapping("/api/reportes/reservas")
    public ResponseEntity<byte[]> reporteReservas() throws Exception {

        List<Reserva> reservas =
                reservaRepository.findAll();

        return generarPdfReservas(reservas);
    }

    private ResponseEntity<byte[]> generarPdfLibros(
            List<Libro> libros)
            throws Exception {

        Document documento =
                new Document();

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        PdfWriter.getInstance(
                documento,
                salida);

        documento.open();

        documento.add(
                new Paragraph(
                        "REPORTE DE LIBROS"));

        documento.add(
                new Paragraph(" "));

        for (Libro libro : libros) {

            documento.add(
                    new Paragraph(
                    "ID: " + libro.getId()
                    + " | Titulo: "
                    + libro.getTitulo()
                    + " | Autor: "
                    + libro.getAutor()));

        }

        documento.close();

        return respuestaPdf(
                salida,
                "libros.pdf");
    }

    private ResponseEntity<byte[]> generarPdfUsuarios(
            List<Usuario> usuarios)
            throws Exception {

        Document documento =
                new Document();

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        PdfWriter.getInstance(
                documento,
                salida);

        documento.open();

        documento.add(
                new Paragraph(
                        "REPORTE DE USUARIOS"));

        documento.add(
                new Paragraph(" "));

        for (Usuario usuario : usuarios) {

            documento.add(
                    new Paragraph(
                    "ID: "
                    + usuario.getId()
                    + " | Nombre: "
                    + usuario.getNombre()
                    + " | Correo: "
                    + usuario.getCorreo()));

        }

        documento.close();

        return respuestaPdf(
                salida,
                "usuarios.pdf");
    }

    private ResponseEntity<byte[]> generarPdfPrestamos(
            List<Prestamo> prestamos)
            throws Exception {

        Document documento =
                new Document();

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        PdfWriter.getInstance(
                documento,
                salida);

        documento.open();

        documento.add(
                new Paragraph(
                        "REPORTE DE PRESTAMOS"));

        documento.add(
                new Paragraph(" "));

        for (Prestamo prestamo : prestamos) {

            documento.add(
                    new Paragraph(
                    "ID: "
                    + prestamo.getId()
                    + " | Usuario: "
                    + prestamo.getUsuario().getNombre()
                    + " | Libro: "
                    + prestamo.getLibro().getTitulo()
                    + " | Estado: "
                    + prestamo.getEstado()));

        }

        documento.close();

        return respuestaPdf(
                salida,
                "prestamos.pdf");
    }

    private ResponseEntity<byte[]> generarPdfReservas(
            List<Reserva> reservas)
            throws Exception {

        Document documento =
                new Document();

        ByteArrayOutputStream salida =
                new ByteArrayOutputStream();

        PdfWriter.getInstance(
                documento,
                salida);

        documento.open();

        documento.add(
                new Paragraph(
                        "REPORTE DE RESERVAS"));

        documento.add(
                new Paragraph(" "));

        for (Reserva reserva : reservas) {

            documento.add(
                    new Paragraph(
                    "ID: "
                    + reserva.getId()
                    + " | Usuario: "
                    + reserva.getUsuario().getNombre()
                    + " | Libro: "
                    + reserva.getLibro().getTitulo()));

        }

        documento.close();

        return respuestaPdf(
                salida,
                "reservas.pdf");
    }

    private ResponseEntity<byte[]> respuestaPdf(
            ByteArrayOutputStream salida,
            String nombreArchivo) {

        return ResponseEntity.ok()

            .header(
                HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename="
                + nombreArchivo)

            .contentType(
                MediaType.APPLICATION_PDF)

            .body(
                salida.toByteArray());
    }

}