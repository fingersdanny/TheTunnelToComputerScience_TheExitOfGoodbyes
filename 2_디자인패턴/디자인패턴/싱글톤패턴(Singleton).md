# 싱글톤 패턴
> 하나의 클래스가 하나의 인스턴스만 갖는 패턴. 하나의 인스턴스를 다른 모듈들이 공유하며 사용합니다.

## 예시

```java
public class Cache {
    private static Cache instance;
    private Map<String, Object> cacheData;

    private Cache() { 
        cacheData = new HashMap<>();
    }

    public static Cache getInstance() {
        if (instance == null) {
            instance = new Cache();
        }
        return instance;
    }

    public void put(String key, Object value) {
        cacheData.put(key, value);
    }

    public Object get(String key) {
        return cacheData.get(key);
    }
}

Cache cache = Cache.getInstance();
cache.put("user1", "John Doe");
String user = (String) cache.get("user1");

```

> 애플리케이션의 여러 부분에서 자주 사용되는 데이터를 메모리에 저장하고 재사용할 수 있게 캐시를 사용합니다. 이러한 캐시 시스템이 여러 개 존재하게 되면 데이터 일관성이 깨질 수 있기 때문에 캐시 객체를 싱글톤으로 만들어 하나의 중앙 캐시를 통해 데이터를 관리합니다.

## 장단점
### 장점
1. 전역 접근성: 애플리케이션 내의 모든 부분에서 동일한 인스턴스를 공유하고 사용할 수 있습니다.
2. 자원 관리: 데이터베이스 연결, 캐시, 설정 관리 등 자원을 효율적으로 관리할 수 있습니다.
3. 일관성: 인스턴스가 하나이므로 데이터를 관리하는 데 있어 일관성을 유지할 수 있습니다.
### 단점
1. 테스트 어려움: 싱글톤 객체는 전역적으로 사용되기 때문에 유닛 테스트에서 객체 간의 의존성을 분리하기 어렵습니다.
2. 유연성 저하: 싱글톤 객체를 변경하거나 확장하기 어려울 수 있습니다. 특히 멀티스레드 환경에서는 동기화 문제가 발생할 수 있습니다.
3. 구현 난이도: 멀티스레드 환경에서 싱글톤 패턴을 구현할 때 동기화와 관련된 문제를 신경 써야 합니다.

## 의존성 주입
싱글톤 객체는 단일 클래스의 단일 인스턴스이기 때문에 내부 구현을 변경 시 어플리케이션 전역적으로 영향을 받습니다. 이에 따라서 의존성 주입으로 모듈 간의 결합을 좀 더 느슨하게 만들어 줄 수 있습니다. Spring에서는 DI Container가 현재 등록된 빈에서 상위 모듈에 주입해야할 빈을 찾아서 등록해주는 방식으로 싱글톤 패턴으로 인해 생기는 강한 결합성 문제를 해결합니다.

이 때 생성자 주입을 통해 의존성을 강제하여 의존성 주입의 안정성을 높일 수 있고, 의존성이 있는 하위 모듈을 추상화 함으로써 구현에 의존하지 않게 되어 ISP (인터페이스 분리 원칙)을 따를 수 있게 됩니다. 이때 추상화는 세부 구현에 의존하지 않아야 합니다.