<%@ include file="header.jspf" %>
<article>
    <section>
        <form action="search" method="post">
        <fieldset>
        <legend>Suchen</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="search">
                        Suche:
                    </label>
                </th>
                <td>
                    <input 
                        type="text" 
                        name="search"
                        size="40"
                        maxlength="40"
                        title="Suchtext"
                        placeholder=
                        "Suchtext eingeben"
                        >
                </td>
                <td>
                    <input type="submit">
                    <input type="reset">
                </td>
            </tr>
        </tbody>
        </table>
        </fieldset>
        </form>
    </section>
</article>
<c:forEach var="item" items="${items}">
<article>
    <section>
        <form action="buy" method="post">
        <fieldset>
        <legend>ID: ${item.id}</legend>
        <h2>${item.title}</h2>  
        <p>${item.description}</p>
        <p><img src="foto?id=${item.id}">
        <p>Preis: ${item.price} Euro</p>
        </fieldset>
        </form>
    </section>
</article>
</c:forEach>
<%@ include file="footer.jspf" %> 


