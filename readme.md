localhost:8080/pilot/add?id=1&licenseNumber=1234&name=Jono&flyHour=20
Pertanyaan 1​: apakah hasilnya? Jika error, tuliskan penjelasan Anda.

Data Berhasil Ditampilkan

----------------------------------------------------------------------------------

localhost:8080/pilot/add?id=1&licenseNumber=1234&name=Jono
Pertanyaan 2: ​apakah hasilnya? Jika error, tuliskan penjelasan Anda

There was an unexpected error (type=Bad Request, status=400).
Required Long parameter 'flyHour' is not present

error terjadi karena tidak ada flyHour pada request parameter, padahal parameter flyHour mempunyai value required = true

----------------------------------------------------------------------------------
localhost:8080/pilot/add?id=1&licenseNumber=1234&name=Jono&flyHour=20
localhost:8080/pilot/view?licenseNumber=1234
Pertanyaan 3​: apakah data Pilot tersebut muncul? Jika tidak, mengapa?

muncul

----------------------------------------------------------------------------------
Coba matikan program dan jalankan kembali serta buka
localhost:8080/pilot/view?licenseNumber=1234
Pertanyaan 4​: apakah data Pilot tersebut muncul? Jika tidak, mengapa?

tidak, karena data yang disimpan hanya sementara (masih dalam lingkup java, belum terhubung dengan database)

----------------------------------------------------------------------------------
localhost:8080/pilot/add?id=1&licenseNumber=1234&name=Jono&flyHour=20
localhost:8080/pilot/viewall
Pertanyaan 5​: apakah data Pilot tersebut muncul?

muncul

----------------------------------------------------------------------------------
Coba tambahkan data Pilot lainnya dengan NPM yang berbeda, lalu buka
localhost:8080/pilot/viewall
Pertanyaan 6​: Apakah semua data Pilot muncul?

muncul

----------------------------------------------------------------------------------

http://localhost:8080/pilot/add?id=1&licenseNumber=12345&name=Jobo&flyHour=20