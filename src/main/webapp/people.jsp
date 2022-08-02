<%@ page import="net.sni.servletbasic.model.Response" %>
<%@ page import="net.sni.servletbasic.dto.PersonDto" %><%--
  Created by IntelliJ IDEA.
  User: egurkan
  Date: 29/07/2022
  Time: 17:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"
            integrity="sha256-lSjKY0/srUM9BE3dPm+c4fBo1dky2v27Gdjm2uoZaL0=" crossorigin="anonymous"></script>
    <script src="https://cdn.tailwindcss.com"></script>
    <script>
        tailwind.config = {
            darkMode: "class",
        }
    </script>
    <title>People</title>
</head>
<body class="antialiased text-slate-500 dark:text-slate-400 bg-white dark:bg-slate-900">
<nav class="sticky top-0 z-50 backdrop-blur-sm bg-slate-500/[.1] text-slate-500 dark:text-slate-400 border-gray-200 px-2 sm:px-4 py-2.5 rounded">
    <div class="container flex flex-wrap justify-between items-center mx-auto">
        <a href="${pageContext.request.contextPath}/" class="flex items-center">
            <img src="${pageContext.request.contextPath}/resources/img/SW_Logo.png" class="mr-3 h-6 sm:h-9"
                 alt="Star Wars">
            <span class="self-center text-xl font-semibold whitespace-nowrap">API</span>
        </a>
        <button data-collapse-toggle="navbar-default" type="button"
                class="inline-flex items-center p-2 ml-3 text-sm rounded-lg md:hidden focus:outline-none focus:ring-2 text-white hover:bg-yellow-300 focus:ring-yellow-400"
                aria-controls="navbar-default" aria-expanded="false">
            <span class="sr-only">Open main menu</span>
            <svg class="w-6 h-6" aria-hidden="true" fill="currentColor" viewBox="0 0 20 20"
                 xmlns="http://www.w3.org/2000/svg">
                <path fill-rule="evenodd"
                      d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
                      clip-rule="evenodd"></path>
            </svg>
        </button>
        <div class="hidden w-full md:block md:w-auto" id="navbar-default">
            <ul class="flex flex-col p-4 mt-4 rounded-lg md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium md:border-0 bg-transparent">
                <li>
                    <a href="${pageContext.request.contextPath}/"
                       class="block py-2 pr-4 pl-3 text-slate-500 dark:text-slate-400 rounded hover:bg-yellow-100 md:hover:bg-transparent md:border-0 md:hover:text-yellow-300 md:p-0"
                       aria-current="page">Home</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/people/"
                       class="block py-2 pr-4 pl-3 text-slate-500 dark:text-slate-400 rounded hover:bg-yellow-100 md:hover:bg-transparent md:border-0 md:hover:text-yellow-300 md:p-0">People</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/planets/"
                       class="block py-2 pr-4 pl-3 text-slate-500 dark:text-slate-400 rounded hover:bg-yellow-100 md:hover:bg-transparent md:border-0 md:hover:text-yellow-300 md:p-0">Planets</a>
                </li>
                <li>
                    <button id="theme-toggle" type="button"
                            class="bg-transparent">
                        <img src="${pageContext.request.contextPath}/resources/img/SW_DeathStar.png"
                             id="theme-toggle-dark-icon" class="hidden w-5 h-5"/>
                        <img src="${pageContext.request.contextPath}/resources/img/SW_TwinSuns.png"
                             id="theme-toggle-light-icon" class="hidden w-5 h-5"/>
                    </button>
                </li>
            </ul>
        </div>
    </div>
</nav>
<% if (request.getAttribute("response") != null) {
    Response<PersonDto> resp = (Response<PersonDto>) request.getAttribute("response"); %>
<div class="relative max-w-4xl mx-auto px-4 sm:px-6 md:px-8">
    <div class="mt-4 -mb-3">
        <div class="not-prose relative bg-slate-50 rounded-xl overflow-hidden dark:bg-slate-800/25">
            <div style="background-position:10px 10px"
                 class="absolute inset-0 bg-grid-slate-100 [mask-image:linear-gradient(0deg,#fff,rgba(255,255,255,0.6))] dark:bg-grid-slate-700/25 dark:[mask-image:linear-gradient(0deg,rgba(255,255,255,0.1),rgba(255,255,255,0.5))]"></div>
            <div class="relative rounded-xl overflow-auto">
                <div class="shadow-sm overflow-hidden my-8">
                    <table class="border-collapse table-auto w-full text-sm">
                        <thead>
                        <tr>
                            <th class="border-b dark:border-slate-600 font-medium p-4 pl-8 pt-0 pb-3 text-slate-400 dark:text-slate-200 text-left">
                                NAME
                            </th>
                            <th class="border-b dark:border-slate-600 font-medium p-4 pl-8 pt-0 pb-3 text-slate-400 dark:text-slate-200 text-left">
                                GENDER
                            </th>
                            <th class="border-b dark:border-slate-600 font-medium p-4 pl-8 pt-0 pb-3 text-slate-400 dark:text-slate-200 text-left">
                                BIRTH YEAR
                            </th>
                        </tr>
                        </thead>
                        <tbody class="bg-white dark:bg-slate-800">
                        <% for (PersonDto person : resp.getResults()) { %>
                        <tr class="dark:hover:bg-slate-700 hover:bg-slate-100 handle">
                            <td class="border-b border-slate-100 dark:border-slate-700 p-4 pl-8 text-slate-500 dark:text-slate-400">
                                <a href="<%=person.getUrl()%>"><%= person.getName() %>
                                </a>
                            </td>
                            <td class="border-b border-slate-100 dark:border-slate-700 p-4 pl-8 text-slate-500 dark:text-slate-400"><%= person.getGender() %>
                            </td>
                            <td class="border-b border-slate-100 dark:border-slate-700 p-4 pl-8 text-slate-500 dark:text-slate-400"><%= person.getBirthYear() %>
                            </td>
                        </tr>
                        <% } %>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th class="font-medium p-4 pl-8 pb-0 pt-3 dark:text-slate-200 text-left">
                                <%="Showing " + resp.getResults().size() + " of " + resp.getCount().intValue() + " entities."%>
                            </th>
                            <th class="font-medium p-4 pl-8 pb-0 pt-3 dark:text-slate-200 text-left"></th>
                            <th class="font-medium p-4 pl-8 pb-0 pt-3 dark:text-slate-200 text-left">
                                <div>
                                    <a id="table-prev" class="pr-2"
                                       href="${pageContext.request.contextPath}/people?page=<%=((int) request.getAttribute("page")) - 1%>">Previous</a>
                                    <a id="table-next"
                                       href="${pageContext.request.contextPath}/people?page=<%=((int) request.getAttribute("page")) + 1%>">Next</a>
                                </div>
                            </th>
                        </tr>
                        </tfoot>
                    </table>
                </div>
            </div>
            <div class="absolute inset-0 pointer-events-none border border-black/5 rounded-xl dark:border-white/5"></div>
        </div>
    </div>
</div>
<%}%>

<script type="text/javascript">
    $("tbody").sortable();
</script>
<script src="${pageContext.request.contextPath}/resources/js/theme-manager.js"></script>
</body>
</html>
