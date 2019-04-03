<#import "parts/common.ftl" as c>

<@c.page>
<#if errorMessage??>
<div class="alert alert-danger" role="alert">
    ${errorMessage}
</div>
</#if>
<a href="/refbook/${refbookid}">Назад к справочнику</a>
<h2>Редактирование элемента <span style="color: blue">${refrecord.name}</span></h2>
<div>
    <div>
        <form action="/refbook/refrecord/save/" method="post">
            <input type="text" name="name" value="${refrecord.name}"/>
            <input type="hidden" name="idrefrecord" value="${refrecord.id}">
            <button type="submit">Сохранить</button>
        </form>
    </div>
</div>
</@c.page>