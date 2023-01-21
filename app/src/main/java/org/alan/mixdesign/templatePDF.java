package org.alan.mixdesign;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class templatePDF {
    private Context context;
    private File pdfFile;
    private com.itextpdf.text.Document document;
    private PdfWriter pdfWriter;
    private Paragraph paragraph;
    private Font fTitle = new Font(Font.FontFamily.TIMES_ROMAN, 20, Font.BOLDITALIC);
    private Font fSubTitle = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLDITALIC);
    private Font fTitleCell = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
    private Font fTextCell = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
    private Font fdm = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLDITALIC);
    private Font fText = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.ITALIC);
    private Font fText2 = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLDITALIC);
    private Font fHightText = new Font(Font.FontFamily.TIMES_ROMAN, 15, Font.BOLD, BaseColor.RED);
    Bitmap bmp;


    public templatePDF(Context context) {
        this.context=context;

    }
    Date currentTime = new Date();
    long timestamp = currentTime.getTime();



    public void openDocument(){
        createFile(context);
        try{
            document =new Document(PageSize.A4);
            pdfWriter=PdfWriter.getInstance(document,new FileOutputStream(pdfFile));
            document.open();


        }catch (Exception e){
            Log.e("OpenDocument", e.toString());
        }
    }
    private static final int CREATE_PDF_REQUEST_CODE = 111;

    private void createFile(Context context){
        /*--->Almacenamiento Interno(Funcional)
        String path = context.getExternalFilesDir(null)+"/pdfGenerate";
        File folder = new File(path);
        if(!folder.exists())
            folder.mkdirs();
        pdfFile = new File(folder, "Diseño_De_Mezcla.pdf");*/


        /*--->Almacenamiento Seleccionado(Funcional-seleccionar el Uri al guardarlo)
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);

        intent.setType("application/pdf");

        File file = new File(context.getExternalFilesDir(null), "mi_archivo.pdf");
        Uri uri = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

        activ.startActivityForResult(intent, CREATE_PDF_REQUEST_CODE);*/


        //Almacenamiento Interno(Funcional-Se vizualizan los archivos con un administrados para )

        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File folder = new File(path,"Carp._Diseño_De_Mezcla");
        if(!folder.exists())
        {folder.mkdirs();}
        pdfFile = new File(folder, "Diseño_De_Mezcla_"+timestamp+".pdf");


    }


    public void closeDocument(){
        document.close();
    }

   public void addimage() throws MalformedURLException {




}


    public void addMetaData(String title, String subject, String author){
        document.addTitle(title);
        document.addSubject(subject);
        document.addAuthor(author);
    }
    public void addTittles(String title){
        try{
            paragraph =new Paragraph();
            addChildP(new Paragraph(title,fTitle ));
            paragraph.setSpacingBefore(0);
            paragraph.setSpacingAfter(3);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("Error al añadir títulos", e.toString());
        }
    }
    public void addsubTittles(String subtitle){
        try{
            paragraph =new Paragraph();
            addChildP(new Paragraph(subtitle,fSubTitle ));
            paragraph.setSpacingAfter(10);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("Error al de subtítulos", e.toString());
        }
    }
    private void addChildP(Paragraph childParagraph){
        childParagraph.setAlignment(Element.ALIGN_CENTER);
        paragraph.add(childParagraph);
    }
    public void addTexto(String titulo){
        try{
            paragraph= new Paragraph(titulo, fText);
            paragraph.setSpacingAfter(3);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);

        }catch (Exception e){
            Log.e("addParagraph", e.toString());
        }
    }
    public void addTexto2(String titulo){
        try{
            paragraph= new Paragraph(titulo, fText2);
            paragraph.setSpacingAfter(5);
            paragraph.setSpacingBefore(5);
            document.add(paragraph);

        }catch (Exception e){
            Log.e("addParagraph", e.toString());
        }
    }



    public void createTable(String []header, ArrayList<String[]> clients){
        try{
            paragraph= new Paragraph();
            paragraph.setFont(fTextCell);
            PdfPTable pdfPTable = new PdfPTable(header.length);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(15);
            pdfPTable.setSpacingAfter(20);
            PdfPCell pdfPCell;
            int indexC=0;
            while(indexC<header.length){
                pdfPCell= new PdfPCell(new Phrase(header[indexC++], fTitleCell));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfPTable.addCell(pdfPCell);
            }

            for (int indexR=0; indexR<clients.size(); indexR++){

                String[]row = clients.get(indexR);
                for ( indexC=0; indexC<header.length; indexC++){
                    pdfPCell=new PdfPCell(new Phrase(row[indexC]));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setFixedHeight(20);
                    pdfPTable.addCell(pdfPCell);
                }
            }

            paragraph.add(pdfPTable);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("createTable", e.toString());
        }
    }

    public void createTable1(String []header, ArrayList<String[]> clients){
        try{
            paragraph= new Paragraph();
            paragraph.setFont(fTextCell);
            PdfPTable pdfPTable = new PdfPTable(header.length);
            pdfPTable.setWidthPercentage(100);
            pdfPTable.setSpacingBefore(10);
            pdfPTable.setSpacingAfter(20);
            pdfPTable.setHorizontalAlignment(Element.ALIGN_CENTER);
            PdfPCell pdfPCell;
            int indexC=0;
            while(indexC<header.length){
                pdfPCell= new PdfPCell(new Phrase(header[indexC++], fTitleCell));
                pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfPCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfPTable.addCell(pdfPCell);
            }

            for (int indexR=0; indexR<clients.size(); indexR++){

                String[]row = clients.get(indexR);
                for ( indexC=0; indexC<header.length; indexC++){
                    pdfPCell=new PdfPCell(new Phrase(row[indexC]));
                    pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfPCell.setFixedHeight(30);
                    pdfPTable.addCell(pdfPCell);
                }
            }

            paragraph.add(pdfPTable);
            document.add(paragraph);
        }catch (Exception e){
            Log.e("createTable", e.toString());
        }
    }



    public void viewPDF_a(){
        Intent intent= new Intent(context, ViewPDF.class);
        intent.putExtra("path", pdfFile.getAbsolutePath());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }

}
