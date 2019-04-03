<#import "parts/common.ftl" as c>

<@c.page>
<h3>Справочник, ${refbook.name}</h3>
<div>
    <div>
        Добавить новый элемент:
        <form action="/refbook/addrecord" method="post">
            <input type="text" name="name" placeholder="Название элемента"/>
            <input type="hidden" name="idrefbook" value="${refbook.id}">
            <button type="submit">Добавить</button>
        </form>
    </div>
<br/>
    <div>Список элементов Справочника:</div>
    <div class order>
        <#if (refrecords?size > 0)>
            <div class="header row">
                <div class="col-md-6" data-orderby="element">Элемент</div>
            </div>
        </#if>
        <div class="list">
            <#list refrecords as refrecord>
            <div class="col-md-6"><span data-name="element">
                        <form action="/refbook/delrecord" method="post">
                            <td><a href="/refbook/refrecord/${refrecord.id}">${refrecord.name}</a></td>
                            <input type="hidden" name="id" value="${refrecord.id}">
                            <input type="hidden" name="idrefbook" value="${refbook.id}">
                            <td><button type="submit">Удалить</button></td>
                        </form>
            </div>
            <#else>
            Элементов не найдено
            </#list>
        </div>
    </div>
</div>
</@c.page>