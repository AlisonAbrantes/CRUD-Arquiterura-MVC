<%-- 
    Document   : alterar_situacao
    Created on : 16/04/2019, 19:11:05
    Author     : alunocmc
--%>
<%@page import="modelo.Departamento"%>
<%@page import="modelo.Tipo"%>
<%@page import="modelo.Situacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Produto</title>
    </head>
    <body>


        <form action="<%= application.getContextPath()%>/ControlePessoa" methodo="POST">

            <input type="hidden" name="acao" id="acao" value="Cadastrar"/>

            <div>
                <label>Descrição</label>
                <input type="text" name="txtdescricao" id="txtdescricao" value="${descricaoviewstate}"/>
            </div>
            <div>
                <label>Quantidade</label>
                <input type="text" name="txtquantidade" id="txtquantidade" value="${Quantidadeviewstate}"/>
            </div>
           
            <div>
                <label>Situação</label>
                <select name="cmbsituacao">
                    <%
                        ArrayList<Situacao> arrsituacao = new ArrayList<Situacao>();
                        arrsituacao = (ArrayList<Situacao>) request.getSession().getAttribute("arrsituacao");
                        for (Situacao obj : arrsituacao) {
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>
            <div>
                <label>Departamento</label>
                <select name="cmbdepartamento" id="cmbdepartamento" onchange="this.form.submit();">
                    <option value="0" selected="selectd">Slecione um Departamento </option>
                     <%
                        ArrayList<Departamento> arrdepto = new ArrayList<Departamento>();
                        arrdepto = (ArrayList<Departamento>) request.getSession().getAttribute("arrdepto");
                        for (Departamento obj : arrdepto) {
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %> 
                </select>
            </div>
            <div>
                <label>Tipo</label>
                <select name="cmbtipo" id="cmbtipo">
                    <option value="0" selected="selectd">Selecione um Tipo de Produto </option>
                  <%
                        ArrayList<Tipo> arrtipo = new ArrayList<Tipo>();
                        arrtipo = (ArrayList<Tipo>) request.getSession().getAttribute("arrtipo");
                        for (Tipo obj : arrtipo) {
                    %>
                    <option value="<%= obj.getId()%>"><%= obj.getDescricao()%></option>
                    <%
                        }
                    %>
                </select>
            </div>

            <div>
                <input type="submit" name="btncadastrar" id="btncadastrar" value="Cadastrar"/>   
            </div>

        </form>

    </body>
</html>
