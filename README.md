# Shipping Strategy Calculator

Aplicación de consola en **Java** para calcular costes de envío utilizando el **patrón de diseño Strategy**.

Este proyecto está orientado a reforzar conceptos de **Programación Orientada a Objetos (OOP)** y comprender cómo los patrones de diseño mejoran la flexibilidad y mantenibilidad del código.



## Funcionalidades

- Catálogo de productos modelado con `enum`
- Métodos de envío modelados con `enum`
- Implementación del patrón **Strategy**
  - Envío aéreo
  - Envío terrestre
  - Envío marítimo
- Resolución de estrategias mediante `EnumMap`
- Capa de servicio para orquestar la lógica
- Separación clara de responsabilidades


## Estructura del Proyecto

El proyecto está organizado en paquetes para asegurar una separación clara de funciones:

| Paquete | Responsabilidad |
| :--- | :--- |
| **`app`** | Punto de entrada de la aplicación (`Main`). |
| **`ui`** | Interacción con el usuario y manejo de entrada/salida por consola. |
| **`service`** | Orquestación de la lógica de negocio y coordinación de capas. |
| **`registry`** | Resolución y registro de estrategias (Strategy Factory). |
| **`strategy`** | Definición de la interfaz e implementaciones del patrón Strategy. |
| **`domain`** | Modelos de dominio y Enums (Producto, Tipo de Envío). |


## Cómo Ejecutar

1. Clonar el repositorio:

```bash
git clone https://github.com/DelxMG/shipping-strategy-calculator.git
