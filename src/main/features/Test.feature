Feature: Test

  Scenario: Test
    Given 로그인
    When 좌측 메뉴의 차량관리 선택
    When 내부 용도차 관리 선택
    When 신규등록 선택
    When 임의 차량목적 드롭박스 선택
    When VIN 번호 입력
    When 확인 버튼 선택
    When 체크 박스 선택
    When 수정 버튼 클릭
    When 삭제 버튼 클릭
    When alert창 확인 버튼 클릭
    Then 삭제되었는지 확인


  Scenario: Gmarket 출석체크
    Given Gmarket 로그인 "dolikelove" "Qwer112233"
    When Gmarket 출석체크