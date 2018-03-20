<%@ include file="header.jspf" %> 
    <form action="register" method="post">
    <fieldset>
    <legend>Registrieren</legend>
    <table>
        <tbody>
        <tr>
            <th>
                <label for="email">Email:</label>
            </th>
            <td>
                <input 
                    type="email" 
                    name="email"
                    size="40"
                    maxlength="40"
                    title="muster@beispiel.de"
                    placeholder="E-Mail eingeben"
                    pattern=".{6,40}" 
                    required="required">
            </td>
        </tr>
        <tr>
            <th>
                <label for="password">
                    Password:
                </label>
            </th>
            <td>
                <input 
                    type="password" 
                    name="password"
                    size="10"
                    maxlength="10"
                    title="6-10 Zeichen"
                    placeholder=
                        "Passwort eingeben"
                    pattern=".{6,10}" 
                    required="required">
            </td>
        </tr>
        <tr>
            <td/><td>
                <input type="submit">         
                <input type="reset">         
            </td>
        </tr>
    </tbody>
    </table>
    </fieldset>
    </form>
<%@ include file="footer.jspf" %>
