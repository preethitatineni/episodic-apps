create table episodes (
  id bigint not null auto_increment primary key,
  show_id bigint not null,
  season_number bigint not null,
  episode_number bigint not null
);