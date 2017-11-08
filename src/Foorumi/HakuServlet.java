package Foorumi;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Hakukone", urlPatterns = {"/hakukone"})
public class HakuServlet extends HttpServlet {

    @Resource(name = "jdbc/Foorumi")
    DataSource ds;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection con = null;
        try {
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        String haettava = (String) request.getParameter("haettava");


        StringBuilder palauta1 = new StringBuilder();
        StringBuilder palauta2 = new StringBuilder();
        StringBuilder palauta3 = new StringBuilder();
        StringBuilder palauta4 = new StringBuilder();
        StringBuilder palauta5 = new StringBuilder();
        StringBuilder palauta6 = new StringBuilder();

        try {

            //            ***********************************************************************************************

            String sql1 = "select keskusteluid, nimi from keskustelu where nimi like ?";
            PreparedStatement kyselyLause1 = con.prepareStatement(sql1);
            kyselyLause1.setString(1, haettava);
            ResultSet kyselynTulos1 = kyselyLause1.executeQuery();

            while (kyselynTulos1.next()) {
                String testi = kyselynTulos1.getString("nimi");
                int testi2 = kyselynTulos1.getInt("keskusteluid");

                if (haettava.contains(testi)) {
                    palauta1.append("<p>");
// Tee palautus URL --> joka hakee keskustelu/keskusteluID
                    palauta1.append("<a href='LOREM_IPSUS' target=_blank>");
                    palauta1.append("Hakusana esiintyy keskustelun nimessä");
                    palauta1.append("</a>");
                    palauta1.append("</p>");
                }
            }

//            ***********************************************************************************************

            String sql2 = "select keskusteluid, kuvaus from keskustelu where kuvaus like ?";
            PreparedStatement kyselyLause2 = con.prepareStatement(sql2);
            kyselyLause2.setString(1, haettava);
            ResultSet kyselynTulos2 = kyselyLause2.executeQuery();

            while (kyselynTulos2.next()) {
                String tulosTeksti = kyselynTulos2.getString("kuvaus");
                int tulosID = kyselynTulos2.getInt("keskusteluid");

                if (haettava.contains(tulosTeksti)) {
                    palauta2.append("<p>");
// Tee palautus URL --> joka hakee keskustelu/keskusteluID
                    palauta2.append("<a href='LOREM_IPSUS' target=_blank>");
                    palauta2.append("Hakusana esiintyy keskustelun kuvauksessa");
                    palauta2.append("</a>");
                    palauta2.append("</p>");
                }
            }


//            ***********************************************************************************************

            String sql3 = "select keskusteluid, kirjoittaja from viesti where kirjoittaja like ?";
            PreparedStatement kyselyLause3 = con.prepareStatement(sql2);
            kyselyLause3.setString(1, haettava);
            ResultSet kyselynTulos3 = kyselyLause3.executeQuery();

            while (kyselynTulos3.next()) {
                String tulosTeksti = kyselynTulos3.getString("kirjoittaja");
                int tulosID = kyselynTulos3.getInt("keskusteluid");

                if (haettava.contains(tulosTeksti)) {
                    palauta3.append("<p>");
// Tee palautus URL --> joka hakee keskustelu/keskusteluID
                    palauta3.append("<a href='LOREM_IPSUS' target=_blank>");
                    palauta3.append("Hakusana esiintyy kirjoittajan nimimerkissä");
                    palauta3.append("</a>");
                    palauta3.append("</p>");
                }
            }


//            ***********************************************************************************************

            String sql4 = "select keskusteluid, otsikko from viesti where otsikko like ?";
            PreparedStatement kyselyLause4 = con.prepareStatement(sql2);
            kyselyLause3.setString(1, haettava);
            ResultSet kyselynTulos4 = kyselyLause4.executeQuery();

            while (kyselynTulos4.next()) {
                String tulosTeksti = kyselynTulos4.getString("otsikko");
                int tulosID = kyselynTulos4.getInt("keskusteluid");

                if (haettava.contains(tulosTeksti)) {
                    palauta4.append("<p>");
// Tee palautus URL --> joka hakee keskustelu/keskusteluID
                    palauta4.append("<a href='LOREM_IPSUS' target=_blank>");
                    palauta4.append("Hakusana esiintyy viestin otsikossa");
                    palauta4.append("</a>");
                    palauta4.append("</p>");
                }
            }

//            ***********************************************************************************************

            String sql5 = "select keskusteluid, viesti from viesti where viesti like ?";
            PreparedStatement kyselyLause5 = con.prepareStatement(sql2);
            kyselyLause5.setString(1, haettava);
            ResultSet kyselynTulos5 = kyselyLause5.executeQuery();

            while (kyselynTulos5.next()) {
                String tulosTeksti = kyselynTulos5.getString("viesti");
                int tulosID = kyselynTulos5.getInt("keskusteluid");

                if (haettava.contains(tulosTeksti)) {
                    palauta5.append("<p>");
// Tee palautus URL --> joka hakee keskustelu/keskusteluID
                    palauta5.append("<a href='LOREM_IPSUS' target=_blank>");
                    palauta5.append("Hakusana esiintyy viestin leipätekstissä");
                    palauta5.append("</a>");
                    palauta5.append("</p>");
                }
            }

            //            ***********************************************************************************************


            String sql6 = "select keskusteluid, vastaus from viesti where vastaus like ?";
            PreparedStatement kyselyLause6 = con.prepareStatement(sql2);
            kyselyLause5.setString(1, haettava);
            ResultSet kyselynTulos6 = kyselyLause5.executeQuery();

            while (kyselynTulos6.next()) {
                String tulosTeksti = kyselynTulos6.getString("vastaus");
                int tulosID = kyselynTulos6.getInt("keskusteluid");

                if (haettava.contains(tulosTeksti)) {
                    palauta6.append("<p>");
// Tee palautus URL --> joka hakee keskustelu/keskusteluID
                    palauta6.append("<a href='LOREM_IPSUS' target=_blank>");
                    palauta6.append("Hakusana esiintyy viestiketjun vastauksessa");
                    palauta6.append("</a>");
                    palauta6.append("</p>");
                }
            }

            //            ***********************************************************************************************


        } catch (SQLException e) {
            e.printStackTrace();
        }


        response.setContentType("text/html");

       try(
    PrintWriter out = response.getWriter())

    {

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Haun tulos</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(palauta1.toString());
        out.println("<br/>");
        out.println(palauta2.toString());
        out.println("<br/>");
        out.println(palauta3.toString());
        out.println("<br/>");
        out.println(palauta4.toString());
        out.println("<br/>");
        out.println(palauta5.toString());
        out.println("<br/>");
        out.println(palauta6.toString());
        out.println("</body>");
        out.println("</html>");
    }

}


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Foorumin hakusivu</title>");
            out.println("</head>");
            out.println("<body>");

            // Koska Form-tagista puuttuu "action"-määre, niin toiminto kutsuu tätä samaa servlettiä,
            // eli itseänsä, täältä doGet:istä --> doPost:iin
            out.println("<form method='post'>");

            out.println("Anna yksi hakusana ");
            out.println("<input type='text' name='haettava'>");
            out.println("<input type='submit' value='Lähetä'>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }
}

