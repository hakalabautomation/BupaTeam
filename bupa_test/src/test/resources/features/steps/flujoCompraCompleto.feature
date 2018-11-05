@compra
Feature: se realiza compra con distintos parametros de cliente,despacho,productoy metodo de pago

  @inicio_compra
  Scenario Outline: compra completa como invitado
    When ingreso sku <sku>
    And selecciono cantidad <cantidad>
    And selecciono color<color><tipoProducto>
    And selecciono talla <talla><tipoProducto>
    And se agrega producto al carro
    #And Producto de bonificacion
    And ingreso a pago automatico<seleccionPago>
    And ingreso al carro de compras<ingresoCarro>
    And agregar codigo promocional <cdoDscto><ingresaCdo><ingresoCarro>
    And selecciono ir a la caja <ingresoCarro>
    And selecciono tipo de cliente <cliente>
    And ingresamos datos de cliente <nombreCliente><apellidoCliente><email><telefono><tipoDocumento><nDocumento>
    And selecciono boton continuar
    And seleciono tipo de entrega<tipoEntrega>
    And ingreso Datos Despacho o Tienda <tipoEntrega><tipoDespacho><tipoUbicacion><ubicacion><direccion><numeroCasaDepto><cdgPostal><region><comuna><calle><numeroCalle>
    And selecciono boton continuar compra <tipoEntrega><tipoDespacho>
    And ingreso datos novios bebe y casa <nombreNovio><apellidoNovio><nombreNovia><apellidoNovia><mensajeNovios>
    And selecciono metodo pago<metodoPago>
    And ingreso datos metodo pago <metodoPago><nombre><apellido><nTarjeta><fechaMes><fechaAno><cvv><nCuotas><guardarTarjeta><TipoTarjetaCenco><rut>
    Then I verify the <status> in step

    #guardarTarjeta = true - false
    #ingresoCarro = true - false
    #tipoProducto = variation - standard - option - bundle
    #tipoDespacho = Standard - Program
    #tipoUbicacion = Manual - Automatica
    #cliente = Invitado - Registrado
    #tipoEntrega = Despacho a domicilio - Retiro en tienda
    #metodoPago = Giftcard -  Cencosud Visa o MasterCard - Tmas card - Credit card - Red Compra Card
    #Order type: Guest - Standard Products - Home Delivery - Standard delivery - Giftcard
    @CompraInvitadoProductoEstandardCencosudVisaoMasterCard
    Examples: 
      | sku      | cantidad | color | tipoProducto | talla | seleccionPago | ingresoCarro | cdoDscto | ingresaCdo | pagoEnCaja | cliente    | nombreCliente | apellidoCliente | email | telefono | tipoDocumento | nDocumento | tipoEntrega            | tipoDespacho | tipoUbicacion | region | comuna | ubicacion | direccion | numeroCasaDepto | cdgPostal | calle | numeroCalle | metodoPago                     | nombreNovio | apellidoNovio | nombreNovia | apellidoNovia | mensajeNovios | nombre | apellido | nTarjeta | fechaMes | fechaAno | cvv | nCuotas | guardarTarjeta | TipoTarjetaCenco | rut |
      | "172849" | "2"      | ""    | "standard"   | ""    | "false"       | "true"       | ""       | ""         | ""         | "Invitado" | ""            | ""              | ""    | ""       | ""            | ""         | "Despacho a domicilio" | "Standard"   | "Manual"      | ""     | ""     | ""        | ""        | ""              | ""        | ""    | ""          | "T.Cencosud Visa o MasterCard" | ""          | ""            | ""          | ""            | ""            | ""     | ""       | ""       | ""       | ""       | ""  | ""      | "false"        | ""               | ""  |
