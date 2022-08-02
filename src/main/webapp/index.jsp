<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
    <style>
        html {
            background: url(resources/img/SW_Hyperspace.png) no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }
    </style>
    <title>Star Wars API</title>
</head>
<body class="antialiased bg-transparent flex flex-col w-screen h-screen">

<nav class="sticky top-0 z-50 backdrop-blur-sm bg-white/[.06] border-gray-200 px-2 sm:px-4 py-2.5 rounded">
    <div class="container flex flex-wrap justify-between items-center mx-auto">
        <a href="${pageContext.request.contextPath}/" class="flex items-center">
            <img src="resources/img/SW_Logo.png" class="mr-3 h-6 sm:h-9" alt="Star Wars">
            <span class="self-center text-xl font-semibold whitespace-nowrap text-white">API</span>
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
                       class="block py-2 pr-4 pl-3 text-white rounded hover:bg-yellow-100 md:hover:bg-transparent md:border-0 md:hover:text-yellow-300 md:p-0"
                       aria-current="page">Home</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/people/"
                       class="block py-2 pr-4 pl-3 text-white rounded hover:bg-yellow-100 md:hover:bg-transparent md:border-0 md:hover:text-yellow-300 md:p-0">People</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/planets/"
                       class="block py-2 pr-4 pl-3 text-white rounded hover:bg-yellow-100 md:hover:bg-transparent md:border-0 md:hover:text-yellow-300 md:p-0">Planets</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="relative flex flex-1 justify-center items-center">
    <div class="flex flex-col justify-center items-center bg-slate-900 w-1/4 h-2/3 min-w-fit rounded-lg">
        <i class="text-yellow-300 font-bold text-2xl mb-2">"Hello There!"</i>
        <p class="text-white">- Obi-Wan Kenobi</p>
    </div>
</div>
</body>
</html>