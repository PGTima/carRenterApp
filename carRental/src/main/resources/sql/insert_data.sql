insert into model_car(id, model_name) values (1, 'BMW');
insert into model_car(id, model_name) values (2, 'KIA');
insert into model_car(id, model_name) values (3, 'Toyota');
insert into model_car(id, model_name) values (4, 'Lada');
-----------------------------------------------------------------------------------------
insert into renter(id,name,patronymic,surname) values (1,'Сергей', 'Сергеевич','Иванов');
insert into renter(id,name,patronymic,surname) values (2,'Иван', 'Иванович','Иванов');
-----------------------------------------------------------------------------------------
insert into cars(id, nomer, model_car_id) values(1, 'test001', 1);
insert into cars(id, nomer, model_car_id) values(2, 'test002', 2);
insert into cars(id, nomer, model_car_id) values(3, 'test003', 3);
insert into cars(id, nomer, model_car_id) values(4, 'test004', 4);

alter sequence cars_id_seq restart with 5;
alter sequence model_car_id_seq restart with 5;
alter sequence renter_id_seq restart with 3;