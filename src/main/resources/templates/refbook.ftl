<#import "parts/common.ftl" as c>

<@c.page>
<#if errorMessage??>
    <div class="alert alert-danger" role="alert">
        ${errorMessage}
    </div>
</#if>
<h2>Справочники</h2>
<div>
    Добавить новый справочник
    <form action="/refbook/add" method="post">
        <input type="text" name="name" placeholder="Название справочника"/>
        <button type="submit">Создать</button>
    </form>
</div>
<br><br>
<div>
    <div>Список справочников:</div>
    <table>
        <#list refbooks as refbook>
        <div>

                <tr>
                    <form action="/refbook/del" method="post">
                        <td><a href="/refbook/${refbook.id}">${refbook.name}</a></td>
                        <input type="hidden" name="id" value="${refbook.id}">
                        <td><button type="submit">Удалить</button></td>
                    </form>
                </tr>
        </div>
    <#else>
        Справочников не найдено
    </#list>
    </table>
</div>

</@c.page>