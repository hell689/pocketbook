<#import "parts/common.ftl" as c>

<@c.page>
<h2 class="text-center">Последние новости</h2>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="list-group">
                <a href="https://tut.by" class="list-group-item list-group-item-action active text-center">Tut.by</a>
                <#list tutnews as news>
                <a href="${news.url}" class="list-group-item list-group-item-action" target="_blank">${news.time} - ${news.title}</a>
                <#else>
                Новостей не найдено
                </#list>
            </div>
        </div>
        <div class="col">
            <div class="list-group">
                <a href="https://championat.com/auto" class="list-group-item list-group-item-action active text-center">Championat.com/auto</a>
                <#list autonews as news>
                <a href="${news.url}" target="_blank" class="list-group-item list-group-item-action">${news.time} - ${news.title}</a>
                <#else>
                Новостей не найдено
                </#list>
            </div>
        </div>
    </div>


</@c.page>