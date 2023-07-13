package softeer2nd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    /**
     * Main Test 할 것
     * start 없이 다른 명령어 들어왔을 때
     * move 뒤에 다른게 붙어 들어왔을 때
     * move 뒤에 인자 2개 넘게 들어왔을 때
     * move 뒤에 이상한 위치가 들어왔을 때 ex) a12 zfe 등등
     */

    @Test
    @DisplayName("간단 테스트")
    void hello() {
        int a = 777;
        assertThat(a).isEqualTo(777);
    }
}
