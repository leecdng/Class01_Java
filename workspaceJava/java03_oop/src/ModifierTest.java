import test.DefaultData;
import test.LottoOOP1;
public class ModifierTest {

	public ModifierTest() {
//		LottoOOP1 lotto = new LottoOOP1();
//		lotto.lottoStart();
		
		DefaultData dd = new DefaultData();
		// ��ü��.�������
		System.out.println("�̸�=" + dd.getName());
		// System.out.println("����ó="+ dd.tel); // DefaultData Ŭ������ ��������� public ��� ��� ����
		
		DefaultData dd2 = new DefaultData("�̼���", "010-8888-8888");
		dd2.sum();
		
		// static Test
		DefaultData.sum(); // �� ����� -> ���������� �־ �޼��� ���� �� ������ ������
		// DefaultData.getName(); // static �����ص� ������ - ���������� ���� �� ��ü�� �����ϰų�, ���������� static ������ ����� ��.
		
	}

	public static void main(String[] args) {
		// ����������
		// Ŭ���� : public, default(���������� ������ ��)
		// ������ �޼���, �޼���, ������� : public, protected, default, private
		
		new ModifierTest();
	}

}
