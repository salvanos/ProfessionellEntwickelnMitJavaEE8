<%@ include file="header.jspf" %> 
<article>
	<section>
		<form action="search" method="post">
		<fieldset>
		<legend><fmt:message key="search"/></legend>
		<table>
			<tbody>
			<tr>
				<th>
					<label 
					for="search"><fmt:message key="search"/>:</label>
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
	<c:forEach 
		items="Kirschlorbeer,Lavendel,Bambus" 
		var="offer"
		varStatus="status">
			${status.count}. <fmt:message key="item"/>: 
			<fmt:message key="id"/>: ${status.index} 
			<fmt:message key="item.title"/>: ${status.current}<br>
	</c:forEach>

<%@ include file="footer.jspf" %>
