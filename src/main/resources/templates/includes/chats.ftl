<div class="list-group">
    <#list chats as chat>
        <a href="/chats" class="list-group-item list-group-item-action" aria-current="true">
            <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">${chat.lastMessage.fromUser.lastName}</h5>
                <small>some time ago</small>
            </div>
            <p class="mb-1">${chat.lastMessage.message}</p>
        </a>
    </#list>
</div>