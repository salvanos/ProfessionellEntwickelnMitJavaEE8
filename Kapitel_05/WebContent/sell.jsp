<%@ include file="header.jspf" %> 
	<form 
		action="sell" 
		method="post" 
		enctype="multipart/form-data">
	<fieldset>
	<legend><fmt:message key="sell"/>: </legend>
	<table>
		<tbody>
		<tr>
			<th>
				<label for="title"><fmt:message key="item.title"/>: :</label>
			</th>
			<td>
				<input 
				type="text" 
				name="title"
				size="40"
				maxlength="40"
				title="Ein Titel für den Artikel"
				placeholder="Titel eingeben"
				pattern=".{6,40}" 
				required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label
					for="description">
					<fmt:message key="item.description"/>:
				</label>
			</th>
			<td>
				<textarea 
					name="description"
					cols="100" 
					rows="10" 
					maxlength="1000">
				</textarea>
			</td>
		</tr>
		<tr>
			<th>
				<label
					for="price">
					<fmt:message key="item.price"/>:
				</label>
			</th>
			<td>
				<input 
				type="number" 
				name="price"
				size="40"
				maxlength="40"
				title="Ein Preis fÃ¼r den Artikel"
				placeholder="Preis eingeben"
				pattern=".{1,40}" 
				required="required">
			</td>
		</tr>
		<tr>
			<th>
				<label
					for="foto">
					<fmt:message key="item.foto"/>: 
				</label>
			</th>
			<td>
				<input type="file" name="foto" >
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
