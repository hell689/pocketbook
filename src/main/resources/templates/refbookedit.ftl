<#import "parts/common.ftl" as c>

<@c.page>
<h3>Справочник, ${refbook.name}</h3>
<div>
    <div>Список элементов Справочника:</div>
    <table>
        <#list refrecords as refrecord>
        <div>

            <tr>
                <form action="/refbook/del" method="post">
                    <td><a href="/refbook/${refbook.id}">${refrecord.name}</a></td>
                    <input type="hidden" name="id" value="${refrecord.id}">
                    <td><button type="submit">Удалить</button></td>
                </form>
            </tr>
        </div>
        <#else>
        Элементов не найдено
    </#list>
    </table>
</div>
</@c.page>