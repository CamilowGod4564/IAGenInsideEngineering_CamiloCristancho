package eci.edu.byteProgramming.ejercicio.paper.ejercicio2;

public class Main {
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("ECI PAYMENTS SYSTEM - TEST");
        System.out.println("=".repeat(60));

        // 1. Crear los módulos
        Inventory inventory = new Inventory();
        Facturation facturation = new Facturation();
        Notification notification = new Notification();

        // 2. Crear el observer que reacciona a pagos exitosos
        PaymentEventObserver paymentObserver = new PaymentEventObserver(inventory, facturation, notification);

        // 3. Crear el sistema de pagos y registrar el observer
        ECIPayment eciPayment = new ECIPayment();
        eciPayment.addObserver(paymentObserver);

        // ========== TEST 1: Tarjeta de Crédito (exitoso) ==========
        System.out.println("\n🔵 TEST 1: Credit Card Payment (Successful)");
        System.out.println("-".repeat(40));

        CreditCardPaymentFactory creditCardFactory = new CreditCardPaymentFactory(
                "4532015112830366",  // número de tarjeta
                "John Doe",          // nombre
                "12/25",             // fecha expiración
                "123",               // CVV
                "Calle 123"          // dirección
        );

        boolean success1 = eciPayment.processPayment(
                creditCardFactory,
                250000,              // monto
                "CUST001",           // customerId
                "Gaming Laptop",     // descripción
                "John Doe",          // customerName
                "john@example.com",  // customerEmail
                "LAPTOP001"          // productId
        );

        System.out.println("Result: " + (success1 ? "✅ SUCCESS" : "❌ FAILED"));

        // ========== TEST 2: PayPal (exitoso) ==========
        System.out.println("\n🟢 TEST 2: PayPal Payment (Successful)");
        System.out.println("-".repeat(40));

        PaypalPaymentFactory paypalFactory = new PaypalPaymentFactory(
                "juan@example.com",  // email
                "auth_token_12345678901"  // authToken (más de 10 caracteres)
        );

        boolean success2 = eciPayment.processPayment(
                paypalFactory,
                80000,               // monto
                "CUST002",           // customerId
                "Smartphone",        // descripción
                "Juan Perez",        // customerName
                "juan@example.com",  // customerEmail
                "PHONE001"           // productId
        );

        System.out.println("Result: " + (success2 ? "✅ SUCCESS" : "❌ FAILED"));

        // ========== TEST 3: Criptomoneda (exitoso) ==========
        System.out.println("\n🟡 TEST 3: Cryptocurrency Payment (Successful)");
        System.out.println("-".repeat(40));

        CryptoPaymentFactory cryptoFactory = new CryptoPaymentFactory(
                "0xAbCdEf1234567890AbCdEf1234567890AbCdEf",  // wallet address (más de 26 chars)
                "Bitcoin",           // cryptoType
                500000               // walletBalance (suficiente para el monto)
        );

        boolean success3 = eciPayment.processPayment(
                cryptoFactory,
                250000,              // monto
                "CUST003",           // customerId
                "Gaming Laptop",     // descripción
                "Maria Garcia",      // customerName
                "maria@example.com", // customerEmail
                "LAPTOP001"          // productId
        );

        System.out.println("Result: " + (success3 ? "✅ SUCCESS" : "❌ FAILED"));

        // ========== TEST 4: Tarjeta de Crédito (falla por validación) ==========
        System.out.println("\n🔴 TEST 4: Credit Card Payment (Failed - Invalid CVV)");
        System.out.println("-".repeat(40));

        CreditCardPaymentFactory invalidCardFactory = new CreditCardPaymentFactory(
                "4532015112830366",
                "John Doe",
                "12/25",
                "12",                // CVV inválido (debe ser 3-4 dígitos)
                "Calle 123"
        );

        boolean success4 = eciPayment.processPayment(
                invalidCardFactory,
                250000,
                "CUST004",
                "Gaming Laptop",
                "John Doe",
                "john@example.com",
                "LAPTOP001"
        );

        System.out.println("Result: " + (success4 ? "✅ SUCCESS" : "❌ FAILED"));

        // ========== TEST 5: Criptomoneda (falla por saldo insuficiente) ==========
        System.out.println("\n🔴 TEST 5: Cryptocurrency Payment (Failed - Insufficient Balance)");
        System.out.println("-".repeat(40));

        CryptoPaymentFactory insufficientCryptoFactory = new CryptoPaymentFactory(
                "0xAbCdEf1234567890AbCdEf1234567890AbCdEf",
                "Bitcoin",
                100000               // walletBalance insuficiente (menor al monto 250000)
        );

        boolean success5 = eciPayment.processPayment(
                insufficientCryptoFactory,
                250000,
                "CUST005",
                "Gaming Laptop",
                "Carlos Lopez",
                "carlos@example.com",
                "LAPTOP001"
        );

        System.out.println("Result: " + (success5 ? "✅ SUCCESS" : "❌ FAILED"));

        // ========== TEST 6: PayPal (falla por authToken inválido) ==========
        System.out.println("\n🔴 TEST 6: PayPal Payment (Failed - Invalid Auth Token)");
        System.out.println("-".repeat(40));

        PaypalPaymentFactory invalidPaypalFactory = new PaypalPaymentFactory(
                "test@example.com",
                "short"              // authToken demasiado corto (menos de 10 caracteres)
        );

        boolean success6 = eciPayment.processPayment(
                invalidPaypalFactory,
                80000,
                "CUST006",
                "Smartphone",
                "Test User",
                "test@example.com",
                "PHONE001"
        );

        System.out.println("Result: " + (success6 ? "✅ SUCCESS" : "❌ FAILED"));

        // ========== RESUMEN FINAL ==========
        System.out.println("\n" + "=".repeat(60));
        System.out.println("TEST SUMMARY");
        System.out.println("=".repeat(60));
        System.out.println("Test 1 (Credit Card - Success): " + (success1 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Test 2 (PayPal - Success): " + (success2 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Test 3 (Crypto - Success): " + (success3 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Test 4 (Credit Card - Invalid CVV): " + (!success4 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Test 5 (Crypto - Insufficient Balance): " + (!success5 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("Test 6 (PayPal - Invalid Auth Token): " + (!success6 ? "✅ PASS" : "❌ FAIL"));
        System.out.println("=".repeat(60));
    }
}