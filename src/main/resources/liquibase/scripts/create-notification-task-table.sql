-- liquibase formatted sql

-- changeset BFGprog:1
create table if not exists notification_task(
    id bigint generated by default as identity primary key,
    chat_id bigint not null,
    text text not null,
    notification_date_time timestamp not null
)


