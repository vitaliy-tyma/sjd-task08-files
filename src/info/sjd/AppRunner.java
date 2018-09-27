package info.sjd;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import info.sjd.Get_SHA512;
import info.sjd.LogRec;
import info.sjd.AppendFile;

/**
 * 
 * @author Vitaliy-tyma
 * 
 *
 *         DATA INPUT/OUTPUT
 * 
 *         DONE Create class for data saving process about server connection
 *         with the following fields: time (current system time), session and
 *         IP.
 * 
 *         DONE Create list of 10 instances of this class through implementation
 *         of log recordings //������� ������ �� 10 ����������� ����� ������
 *         ����� ���������� ������ �����
 * 
 *         DONE Fields are to be generated by your own, better to implement own
 *         randomizer for values range. //���� ���������� ����, ����� ��������
 *         ���� ����������� ��� ��������� ��������.
 * 
 *         DONE Record data from the list into TXT file in LOG folder inside of
 *         the project. //�������� ������ �� ������ � txt ���� � ����� log
 *         ������ �������.
 * 
 *         DONE Previous records in the file must be preserved. //����������
 *         ������ � ����� ������ ���� ���������.
 * 
 *         DONE As a result file has to contain such data: 1529666255304
 *         123456789 128.158.234.15 1529666289304 123456799 123.148.214.19 �
 *         First column is time in milliseconds, Second - session (random
 *         9-digits number), Third - IP (also is created by randomly). //���
 *         ������ ������� � ����� � �������������, //������ � ������ (���������
 *         ������������� �����), //������ � IP (���� ��������� ��������)
 * 
 * 
 *         DONE Implement logs recording //������� ���������� ������ �����
 * 
 *         DONE Implement connections logs reading from this file for some
 *         period //������� ���������� ���������� ����� ����������� �� �����
 *         ����� �� ������
 * 
 *         DONE Implement logs deleting from files older then 3 days. //�������
 *         ���������� �������� ����� �� ������ ������ 3-� ����
 * 
 */

public class AppRunner {

	/* MAIN ****************************************/
	public static void main(String[] args) {

		/** INITIALISATION */
		final String DIR_NAME = "log/";
		final String FILE_NAME = DIR_NAME + "task08.txt";
		
		

		/** Save logs to file. */
			AppendFile.appendFile(FILE_NAME);


		/** Read logs from file. Print logs to the logger. */
			ReadFile.readFile(FILE_NAME);


		/** Delete 3 days older records from the log-file. */
			DelOldRecords.delOldRecords(FILE_NAME);


	}

}