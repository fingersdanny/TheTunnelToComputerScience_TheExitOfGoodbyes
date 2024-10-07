# 팩토리 패턴
> 객체의 생성 부분을 떼어내 객체 생성 과정을 캡슐화 하여서 사용하는 패턴입니다.
> 구현하는 방식에 따라 단순 팩토리, 팩토리 메서드 패턴으로 나뉩니다.

## 예시

### 1. 단순 팩토리
```java
// 제품 인터페이스
interface Product {
    void use();
}

// 구체적인 제품 클래스
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Concrete Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Concrete Product B");
    }
}

// 팩토리 클래스
class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ConcreteProductA();
        } else if (type.equals("B")) {
            return new ConcreteProductB();
        }
        throw new IllegalArgumentException("Unknown product type");
    }
}

// 클라이언트 코드
public class Client {
    public static void main(String[] args) {
        Product productA = ProductFactory.createProduct("A");
        productA.use();  // Output: Using Concrete Product A

        Product productB = ProductFactory.createProduct("B");
        productB.use();  // Output: Using Concrete Product B
    }
}
```

```java
// 제품 인터페이스
interface Product {
    void use();
}

// 구체적인 제품 클래스
class ConcreteProductA implements Product {
    @Override
    public void use() {
        System.out.println("Using Concrete Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void use() {
        System.out.println("Using Concrete Product B");
    }
}

// 추상 팩토리 클래스
abstract class ProductFactory {
    public abstract Product createProduct();
}

// 구체적인 팩토리 클래스
class ConcreteProductAFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteProductBFactory extends ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}

// 클라이언트 코드
public class Client {
    public static void main(String[] args) {
        ProductFactory factoryA = new ConcreteProductAFactory();
        Product productA = factoryA.createProduct();
        productA.use();  // Output: Using Concrete Product A

        ProductFactory factoryB = new ConcreteProductBFactory();
        Product productB = factoryB.createProduct();
        productB.use();  // Output: Using Concrete Product B
    }
}
```

> 상위 클래스에서는 객체 생성에 관여하지 않고 만들어서 사용할 뿐이기 때문에 느슨한 결합을 갖습니다.

## 장단점
### 장점

1. **캡슐화**: 객체 생성 로직을 팩토리 클래스에 캡슐화하여 클라이언트 코드가 구체적인 클래스에 의존하지 않게 됩니다.
2. **유연성**: 객체 생성 방법을 쉽게 변경할 수 있으며, 새로운 제품 클래스 추가 시 기존 코드를 수정하지 않고 새로운 팩토리 클래스를 추가하여 확장할 수 있습니다.
3. **코드 유지보수성 향상**: 클라이언트 코드가 생성하는 객체의 구현을 알 필요가 없으므로, 객체 구현 변경 시 클라이언트 코드를 수정할 필요가 없습니다.
4. **디커플링(Decoupling)**: 클라이언트와 객체 생성의 결합도가 낮아져서 서로의 변화에 유연하게 대처할 수 있습니다.

### 단점

1. **복잡성 증가**: 팩토리 패턴을 적용하면 클래스와 인터페이스가 늘어나 코드의 복잡성이 증가할 수 있습니다.
2. **성능 오버헤드**: 객체 생성 시 추가적인 팩토리 메서드 호출이 발생하여 성능에 영향을 줄 수 있습니다.
3. **일관성 유지**: 여러 팩토리 클래스를 사용할 경우, 각 팩토리의 사용 방식이 일관되지 않으면 혼란을 초래할 수 있습니다.
4. **단일 책임 원칙 위반**: 일부 경우, 팩토리 클래스가 너무 많은 책임을 가질 수 있어 단일 책임 원칙(SRP)을 위반하게 될 수 있습니다.