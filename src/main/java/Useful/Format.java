package Useful;

import java.text.*;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.text.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Format {

    static DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static JFormattedTextField getFormatado(String formato) {
        JFormattedTextField campoFormatado = null;
        MaskFormatter format = new MaskFormatter();

        format.setPlaceholderCharacter(' ');
        format.setValueContainsLiteralCharacters(false);

        try {
            format.setMask(formato);
            campoFormatado = new JFormattedTextField(format);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return campoFormatado;
    }

    public static void formatarDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static String formatarDecimal(double valor) {
        NumberFormat formatter = new DecimalFormat("###0.00");
        return (formatter.format(valor));
    }

    public static JFormattedTextField getTelefone() {
        return getFormatado("(##) ####-####");
    }

    public static JFormattedTextField getCNPJ() {
        return getFormatado("##.###.###/####-##");
    }

    public static JFormattedTextField getCPF() {
        return getFormatado("###.###.###-##");
    }

    public static JFormattedTextField getData() {
        return getFormatado("##/##/####");
    }

    public static JFormattedTextField getDataHora() {
        return getFormatado("##/##/#### ##:##");
    }

    public void formatoDecimal(JTextField campo) {
        campo.setText(df.format(Double.parseDouble(campo.getText())));
    }

    public static void formatarData(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("##/##/####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void formatarCpf(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("###.###.###-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void formatarCnpj(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("##.###.###/####-##");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void formatarTelefone(JFormattedTextField campo) {
        try {
            MaskFormatter m = new MaskFormatter();
            m.setPlaceholderCharacter(' ');
            m.setMask("(##)####-####");
            campo.setFormatterFactory(null);
            campo.setFormatterFactory(new DefaultFormatterFactory(m));
            campo.setValue(null);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String ajustaDataDMA(String data) {
        String dataFormatada = null;
        try {
            Date dataAMD = new SimpleDateFormat("yyyy-MM-dd").parse(data);
            dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAMD);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String ajustaDataAMD(String data) {
        String dataFormatada = null;
        try {
            Date dataDMA = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            dataFormatada = new SimpleDateFormat("yyyy-MM-dd").format(dataDMA);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String removerFormatacao(String dado) {
        String retorno = "";
        for (int i = 0; i < dado.length(); i++) {
            if (dado.charAt(i) != '.' && dado.charAt(i) != '/' && dado.charAt(i) != '-') {
                retorno = retorno + dado.charAt(i);
            }
        }
        return (retorno);
    }

    public static String getDataAtual() {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String dataHoje = df.format(now);

        return dataHoje;
    }

    public static Date getDataHoraAtual() throws ParseException {
        Date now = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataHoje = df.format(now);
        Date date = (Date) df.parse(dataHoje);

        return date;
    }

    public static String getDateTime() {
        java.util.Date dt = new java.util.Date();

        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

        String currentTime = sdf.format(dt);
        return currentTime;
    }

    public static String adjustDate2(String data) {
        String dataFormatada = null;
        try {
            Date date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(data);
            dataFormatada = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date);
        } catch (Exception e) {
            System.err.println(e);
        }
        return (dataFormatada);
    }

    public static String adjustDate(String str) {
        return str.substring(0, str.length() - 5);
    }

    public String compareDates(String d1, String d2) {
        try {
            // If you already have date objects then skip 1

            //1
            // Create 2 dates starts
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date1 = sdf.parse(d1);
            Date date2 = sdf.parse(d2);

            System.out.println("Date1" + sdf.format(date1));
            System.out.println("Date2" + sdf.format(date2));
            System.out.println();

            // Create 2 dates ends
            //1
            // Date object is having 3 methods namely after,before and equals for comparing
            // after() will return true if and only if date1 is after date 2
            if (date1.after(date2)) {
                return "Date1 is after Date2";
            }
            // before() will return true if and only if date1 is before date2
            if (date1.before(date2)) {
                return "Date1 is before Date2";
            }

            //equals() returns true if both the dates are equal
            if (date1.equals(date2)) {
                return"Date1 is equal Date2";
            }

            System.out.println();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
