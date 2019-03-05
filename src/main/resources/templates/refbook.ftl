<#import "parts/common.ftl" as c>

<@c.page>
<h2>Справочники</h2>
<div>
    Добавить новый справочник
    <form action="refbook/add" method="post">
        <input type="text" name="name" placeholder="Название справочника"/>
        <button type="submit">Создать</button>
    </form>
</div>
<br><br>
<div>
    <div>Список справочников:</div>
    <#list refbooks as refbook>
        <div>
            ${refbook.name}
        </div>
    <#else>
        Справочников не найдено
    </#list>
</div>

</@c.page>