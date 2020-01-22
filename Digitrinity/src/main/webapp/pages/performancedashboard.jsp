<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

    <%@page import="com.fasterxml.jackson.databind.ObjectMapper" %>
    <%@page import="java.util.HashMap" %>
    <%@page import="java.util.Map" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Site Details</title>
    <jsp:include page="include_hdr.jsp"></jsp:include>
    <style>
        .tabs {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-flex-wrap: wrap;
            -ms-flex-wrap: wrap;
            flex-wrap: wrap;
        }

        .tabs label {
            -webkit-box-ordinal-group: 2;
            -webkit-order: 1;
            -ms-flex-order: 1;
            order: 1;
            display: block;
            padding: 1rem 2rem;
            margin-right: 0.2rem;
            cursor: pointer;
            background: #90CAF9;
            font-weight: bold;
            -webkit-transition: background ease 0.2s;
            transition: background ease 0.2s;
        }

        .tabs .tab {
            -webkit-box-ordinal-group: 100;
            -webkit-order: 99;
            -ms-flex-order: 99;
            order: 99;
            -webkit-box-flex: 1;
            -webkit-flex-grow: 1;
            -ms-flex-positive: 1;
            flex-grow: 1;
            width: 100%;
            display: none;
            padding: 1rem;
            background: #fafafa;
        }

        .tabs input[type="radio"] {
            position: absolute;
            opacity: 0;
        }

        .tabs input[type="radio"]:checked + label {
            background: #fafafa;
        }

        .tabs input[type="radio"]:checked + label + .tab {
            display: block;
        }

        @media (max-width: 45em) {

            .tabs .tab, .tabs label {
                -webkit-box-ordinal-group: NaN;
                -webkit-order: initial;
                -ms-flex-order: initial;
                order: initial;
            }

            .tabs label {
                width: 100%;
                margin-right: 0;
                margin-top: 0.2rem;
            }
        }

        .wrapper {
            display: flex;
            width: 100%;
            align-items: stretch;
        }

        .wrapper {
            display: flex;
            align-items: stretch;
        }

        #sidebar {
            min-width: 250px;
            max-width: 250px;
        }

        #sidebar.active {
            margin-left: -250px;
        }

        #sidebar {
            min-width: 250px;
            max-width: 250px;
            min-height: 100vh;
        }

        a[data-toggle="collapse"] {
            position: relative;
        }

        .dropdown-toggle::after {
            display: block;
            position: absolute;
            top: 50%;
            right: 20px;
            transform: translateY(-50%);
        }

        @import "https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700";


        body {
            font-family: 'Poppins', sans-serif;
            background: #fafafa;
        }

        p {
            font-family: 'Poppins', sans-serif;
            font-size: 1.1em;
            font-weight: 300;
            line-height: 1.7em;
            color: #999;
        }

        a, a:hover, a:focus {
            color: inherit;
            text-decoration: none;
            transition: all 0.3s;
        }

        #sidebar {
            /* don't forget to add all the previously mentioned styles here too */
            background: #7386D5;
            color: #fff;
            transition: all 0.3s;
        }

        #sidebar .sidebar-header {
            padding: 20px;
            background: #6d7fcc;
        }

        #sidebar ul.components {
            padding: 20px 0;
            border-bottom: 1px solid #47748b;
        }

        #sidebar ul p {
            color: #fff;
            padding: 10px;
        }

        #sidebar ul li a {
            padding: 10px;
            font-size: 1.1em;
            display: block;
        }

        #sidebar ul li a:hover {
            color: #7386D5;
            background: #fff;
        }

        #sidebar ul li.active > a, a[aria-expanded="true"] {
            color: #fff;
            background: #6d7fcc;
        }

        ul ul a {
            font-size: 0.9em !important;
            padding-left: 30px !important;
            background: #6d7fcc;
        }
    </style>
</head>
<body style="background-color: #e9e9e9; font-size: .88rem;"
      data-spy="scroll">
<jsp:include page="header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row-12 mt-3 mb-3 p-2 text-center">
        <div class="col-12 p-2" style="background-color: #1A3E4C;color: #E4F1F6;">
            <h5>Site Details</h5>
        </div>
    </div>
</div>


<div class="container-fluid">
    <div class="modal-body row">
        <div class="col-md-2">
            <div class="wrapper">
                <nav id="sidebar">
                    <ul class="list-unstyled components">
                        <li class="active">
                            <a href="#homeSubmenu" >Performance Dashboard</a>

                        </li>
                        <li>
                            <a href="#">Devices</a>
                        </li>
                        <li>
                            <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Pages</a>
                            <ul class="collapse list-unstyled" id="pageSubmenu">
                                <li>
                                    <a href="#">Page 1</a>
                                </li>
                                <li>
                                    <a href="#">Page 2</a>
                                </li>
                                <li>
                                    <a href="#">Page 3</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Events</a>
                        </li>
                        <li>
                            <a href="#">My Site</a>
                        </li>
                    </ul>
                </nav>

            </div>
        </div>
        <div class="col-md-6">
            <div class="tab">
                <button class="tablinks" onclick="return alert ('Solar energy')">
                    <label class='control-label mr-2'><strong>Solar energy</strong></label>
                </button>
                <button class="tablinks" onclick="return alert ('Solar energy')">
                    <label class='control-label mr-2'><strong>Generator energy</strong></label>
                </button>
                <button class="tablinks" onclick="return alert ('Solar energy')">
                    <label class='control-label mr-2'><strong>DC load</strong></label>
                </button>
                <button class="tablinks" onclick="return alert ('Solar energy')">
                    <label class='control-label mr-2'><strong>AC load</strong></label>
                </button>
                <button class="tablinks" onclick="return alert ('Solar energy')">
                    <label class='control-label mr-2'><strong>Battery Energy</strong></label>
                </button>
                <button class="tablinks" onclick="return alert ('Solar energy')">
                    <label class='control-label mr-2'><strong>Inverter Energy</strong></label>
                </button>
            </div>
            <div class="tabs">

                <input type="radio" name="tabs" id="tabone" checked="checked">
                <label for="tabone">Tab One</label>
                <div class="tab">

                </div>

                <input type="radio" name="tabs" id="tabtwo">
                <label for="tabtwo">Tab Two</label>
                <div class="tab">

                </div>

                <input type="radio" name="tabs" id="tabthree">
                <label for="tabthree">Tab Three</label>
                <div class="tab">

                </div>

            </div>
            <table cellspacing="5" cellpadding="5" class="filter-table">
                <br/>
                <tr>
                    <td><label class='control-label mr-2'
                               for="hourly-site-id-select"><strong>Solar energy</strong></label></td>

                    <td><label class='control-label mr-2'
                               for="hourly-site-id-select"><strong> Generator energy</strong></label></td>

                    <td><label class='control-label mr-2'
                               for="hourly-site-id-select"><strong>DC load</strong></label></td>

                    <td><label class='control-label mr-2'
                               for="hourly-site-id-select"><strong>AC load</strong></label></td>

                    <td><label class='control-label mr-2'
                               for="device-type-select"><strong>Battery Energy</strong></label></td>


                    <td><label class='control-label mr-2'
                               for="hourly-site-id-select"><strong>Inverter Energy</strong></label></td>

                </tr>
            </table>
        </div>
    </div>
</div>

<jsp:include page="include_ftr.jsp"></jsp:include>
<script src="${contextPath}/resources/js/rawdatareport.js"
        type="text/javascript"></script>
</body>
</html>
